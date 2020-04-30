package com.k.docker.jenkins;

import com.google.common.collect.*;
import com.k.docker.jenkins.model.emums.BuildItemEnum;
import com.k.docker.jenkins.model.emums.DockerRegionEnum;
import com.k.docker.jenkins.util.PathBaseUtil;
import com.k.docker.jenkins.util.PathUtil;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JenkinsBuildShell {
    static int multi = 20;
    static String[] filters = new String[]{};

    public static void main(String[] args) throws Exception {
        DockerJenkinsModel.setWORKSPACE(args[0]);
        if (args.length > 1 && StringUtils.isNotBlank(args[1])) {
            multi = Integer.parseInt(args[1]);
        }
        if (args.length > 2 && StringUtils.isNotBlank(args[2])) {
            filters = args[2].split(",");
        }
        JenkinsBuildShell shell = new JenkinsBuildShell();
        shell.test();
    }

    @Test
    public void test() throws Exception {
        String resource = PathUtil.getResource();
        File file = new File(resource);
        String dockerDest = "dockerDest/";
        Map<DockerRegionEnum, File> map = Maps.newHashMap();
        copyFile(file, dockerDest, map);
        List<DockerJenkinsModel> models = Lists.newArrayList();
        for (DockerRegionEnum regionEnum : map.keySet()) {
            for (File listFile : Objects.requireNonNull(map.get(regionEnum).listFiles())) {
                models.addAll(readFirst(regionEnum, listFile));
            }
        }
        models = filter(models);
        models.sort((o1, o2) -> NumberUtils.compare(o1.getIndex(), o2.getIndex()));
        writeNormal("", models, true);
        writeSpecial("special/", models, false);

    }

    private List<DockerJenkinsModel> filterNormal(List<DockerJenkinsModel> models) {
        return models.stream().filter(model -> !DockerRegionEnum.filterSpecile(model.getRegion())).collect(Collectors.toList());
    }

    private List<DockerJenkinsModel> filterSpecial(List<DockerJenkinsModel> models) {
        return models.stream().filter(model -> DockerRegionEnum.filterSpecile(model.getRegion())).collect(Collectors.toList());
    }

    private void writeSpecial(String dir, List<DockerJenkinsModel> models, boolean mix) {
        models = filterSpecial(models);
         models = models.stream().filter(model -> StringUtils.equals("x86_64", model.getPlatform())).map(model -> {
             model.setPlatforms(new String[]{});
             model.setPlatform(null);
             return model;
         }).filter(model -> {
             Set<String> ignoreRegions = model.getIgnoreRegions();
             if (CollectionUtils.isNotEmpty(ignoreRegions)) {
                 return !ignoreRegions.contains(model.getRegion());
             } else {
                 return true;
             }
         }).collect(Collectors.toList());
        writeShell(dir, models, mix);
    }

    private void writeNormal(String dir, List<DockerJenkinsModel> models, boolean mix) {
        models = filterNormal(models);
        writeShell(dir, models, mix);
    }

    private void writeShell(String dir, List<DockerJenkinsModel> models, boolean mix) {
        Multimap<String, DockerJenkinsModel> multimap = ArrayListMultimap.create();
        models.forEach(model -> multimap.put(model.getPlatform() + "_" + model.getRegion(), model));
        models.forEach(model -> multimap.put(model.getPlatform(), model));
        multimap.asMap().forEach((regionPlat, dockerJenkinsModels) -> {
            writePlat(dir, regionPlat, dockerJenkinsModels, mix, multi);
            //writePlat(regionPlat, dockerJenkinsModels, false);
        });
    }

    private List<DockerJenkinsModel> filter(List<DockerJenkinsModel> models) {
        if (ArrayUtils.isEmpty(filters)) {
            return models;
        } else {
            return models.stream().filter(model -> StringUtils.indexOfAny(model.getVersion(), filters) > 0).collect(Collectors.toList());
        }
    }

    private void copyFile(File file, String dockerDest, Map<DockerRegionEnum, File> map) throws Exception {
        for (String region : PathBaseUtil.REGIONS) {
            DockerRegionEnum regionEnum = DockerRegionEnum.getRegion(region);
            String copyDest = PathUtil.getTargetPath(dockerDest);
            File copyDestFile = new File(copyDest + "/" + regionEnum.getRegion());
            copyDir(file, file.getAbsolutePath() + "/", copyDest, regionEnum.getRegion());
            map.put(regionEnum, copyDestFile);
        }
    }

    private void copyDir(File dir, String src, String dest, String region) throws Exception {
        for (File listFile : Objects.requireNonNull(dir.listFiles())) {
            if (listFile.isFile()) {
                copyFile(listFile, src, dest, region);
            } else {
                copyDir(listFile, src, dest, region);
            }
        }
    }

    private void copyFile(File srcfile, String src, String dest, String region) throws Exception {
        String absolutePath = srcfile.getAbsolutePath();
        absolutePath = absolutePath.replace(src, dest + region + "/");
        File destfile = new File(absolutePath);
        copyFile(srcfile, destfile, region);
    }

    private void copyFile(File srcfile, File destfile, String region) throws Exception {
        //String region = PathBaseUtil.REGION;
        //String region = "beijing";
        String host = DockerRegionEnum.getRegion(region).getHost();
        List<String> lines = FileUtils.readLines(srcfile, StandardCharsets.UTF_8);
        if (CollectionUtils.isNotEmpty(lines)) {
            if (srcfile.getName().equals("Dockerfile")) {
                String from = lines.get(0);
                String prefix = "king019/";
                int index = from.indexOf(prefix);
                if (index > 0) {
                    lines.remove(0);
                    if (StringUtils.isNotBlank(host)) {
                        host = host + "/" + from.substring(index);
                    } else {
                        host = host + from.substring(index);
                    }
                    from = from.substring(0, index) + host;
                    lines.add(0, from);
                }
            }
        }
        FileUtils.writeLines(destfile, lines);
    }

    private void writePlat(String dir, String plat, Collection<DockerJenkinsModel> models, boolean mix, int multi) {
        List<String> lines = Lists.newArrayList();
        lines.add("#!/bin/sh");
        lines.add("set -x");
        Map<Integer, List<DockerJenkinsModel>> map = models.stream().collect(Collectors.groupingBy(DockerJenkinsModel::getIndex));
        buildBuildLines(lines, map, multi, (strings, model) -> {
            lines.add(model.buildBuild());
            lines.add(model.buildPush());
            if (mix) {
                lines.add(model.getMap().get(model.getPlatform()));
            }
        });
//        buildBuildLines(lines, map, multi, (lines1, model) -> lines1.add(model.buildBuild()));
//        buildBuildLines(lines, map, multi, (lines1, model) -> lines1.add(model.buildPush()));
//        buildBuildLines(lines, map, multi, (lines1, model) -> {
//            if (mix) {
//                lines1.add(model.getMap().get(model.getPlatform()));
//            }
//        });
        String target = PathUtil.getTargetPath(dir + plat + "_" + mix + ".sh");
        File targetFile = new File(target);
        try {
            FileUtils.writeLines(targetFile, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildBuildLines(List<String> lines, Map<Integer, List<DockerJenkinsModel>> map, int multi, BiConsumer<List<String>, DockerJenkinsModel> consumer) {
        List<Integer> indexs = Lists.newArrayList(map.keySet());
        Collections.sort(indexs);
        for (Integer index : indexs) {
            List<DockerJenkinsModel> indexModels = map.get(index);
            List<List<DockerJenkinsModel>> partitionss = Lists.partition(indexModels, multi);
            for (List<DockerJenkinsModel> partitions : partitionss) {
                for (DockerJenkinsModel model : partitions) {
                    lines.add("{");
                    consumer.accept(lines, model);
                    lines.add("}&");
                }
                lines.add("wait");
            }
        }
    }

    private List<DockerJenkinsModel> readFirst(DockerRegionEnum regionEnum, File file) throws Exception {
        Map<String, Map<String, Map<BuildItemEnum, String>>> map = Maps.newLinkedHashMap();
        readDir(file, map);
        return writeLines(regionEnum, map, file);
    }

    private List<DockerJenkinsModel> writeLines(DockerRegionEnum regionEnum, Map<String, Map<String, Map<BuildItemEnum, String>>> map, File firstFile) {
        List<DockerJenkinsModel> models = Lists.newArrayList();
        map.forEach(new BiConsumer<>() {
            @Override
            public void accept(String path, Map<String, Map<BuildItemEnum, String>> pathMap) {
                pathMap.forEach(new BiConsumer<>() {
                    @Override
                    public void accept(String nextPath, Map<BuildItemEnum, String> enumMap) {
                        if (Objects.nonNull(enumMap.get(BuildItemEnum.IGNORE))) {
                            return;
                        }
                        String versions = enumMap.get(BuildItemEnum.VERSION);
                        if (StringUtils.isBlank(versions)) {
                            return;
                        }
                        String[] plats = getPlat(firstFile, enumMap);
                        if (ArrayUtils.isEmpty(plats)) {
                            return;
                        }

                        String[] versionSplits = StringUtils.split(versions, ",");
                        Set<String>ignoreRegionSplits= Sets.newHashSet();
                        String ignoreRegion = enumMap.get(BuildItemEnum.IGNORE_REGION);
                        if(StringUtils.isNotBlank(ignoreRegion)){
                            ignoreRegionSplits.addAll(Sets.newHashSet(StringUtils.split(ignoreRegion, ",")));
                        }
                        Arrays.stream(versionSplits).forEach(new Consumer<>() {
                            @Override
                            public void accept(String version) {
                                Arrays.stream(plats).forEach(new Consumer<>() {
                                    @Override
                                    public void accept(String plat) {
                                        models.add(buildModel(path, plats, plat, version, enumMap, regionEnum.getRegion(),ignoreRegionSplits));
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        return models;
    }

    private DockerJenkinsModel buildModel(String path, String[] plats, String plat, String version, Map<BuildItemEnum, String> enumMap, String region,Set<String> ignoreRegions) {
        DockerJenkinsModel model = new DockerJenkinsModel();
        model.setPath(path);
        model.setIndex(Integer.parseInt(enumMap.getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef())));
        //StringUtils.defaultIfBlank(enumMap.get(BuildItemEnum.REGION), PathBaseUtil.REGION);
        model.setHost(DockerRegionEnum.getRegion(region).getHost());
        model.setRegion(region);
        model.setPlatform(plat);
        model.setVersion(version);
        model.setPlatforms(plats);
        model.setIgnoreRegions(  ignoreRegions);
        return model;
    }

    private String[] getPlat(File firstFile, Map<BuildItemEnum, String> enumMap) {
        String plat = null;
        try {
            plat = enumMap.get(BuildItemEnum.PLATFORM);
            if (StringUtils.isBlank(plat)) {
                File file = new File(firstFile.getAbsolutePath() + "/" + BuildItemEnum.PLATFORM.getItem());
                if (file.exists()) {
                    plat = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.split(plat, ",");
    }

    private void readDir(File file, Map<String, Map<String, Map<BuildItemEnum, String>>> map) throws Exception {
        if (Objects.isNull(file)) {
            return;
        }
        if (file.isFile()) {
            String name = file.getName();
            if (BuildItemEnum.ITEMS.contains(name)) {
                BuildItemEnum item = BuildItemEnum.getItem(name);
                String doc = StringUtils.join(FileUtils.readLines(file, StandardCharsets.UTF_8), ",");
                String path = file.getParentFile().getParentFile().getParentFile().getAbsolutePath();
                String pathNext = file.getParentFile().getAbsolutePath();
                int prePathIndex = path.indexOf(PathBaseUtil.PRE_PATH);
                path = path.substring(prePathIndex);
                Map<String, Map<BuildItemEnum, String>> pathMap = map.computeIfAbsent(path, s -> Maps.newHashMap());
                Map<BuildItemEnum, String> enumMap = pathMap.computeIfAbsent(pathNext, nextPath -> Maps.newHashMap());
                enumMap.put(item, doc);
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (Optional.ofNullable(files).isPresent()) {
                for (File fileInner : files) {
                    readDir(fileInner, map);
                }
            }
        }
    }
}
