package com.k.docker.jenkins;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.k.docker.jenkins.util.PathBaseUtil;
import com.k.docker.jenkins.util.PathUtil;
import com.k.docker.jenkins.util.model.DockerJenkinsModel;
import com.k.docker.jenkins.util.model.enums.BuildItemEnum;
import com.k.docker.jenkins.util.model.enums.DockerRegionEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JenkinsBuildShell {
    public static void main(String[] args) throws Exception {
        DockerJenkinsModel.setWORKSPACE(args[0]);
        JenkinsBuildShell shell = new JenkinsBuildShell();
        shell.test();
    }

    @Test
    public void test() throws Exception {
        String resource = PathUtil.getResource();
        File file = new File(resource);
        String dockerDest = "dockerDest/";
        Map<DockerRegionEnum, File> map = Maps.newHashMap();
        for (DockerRegionEnum regionEnum : DockerRegionEnum.values()) {
            String copyDest = PathUtil.getTargetPath(dockerDest);
            File copyDestFile = new File(copyDest + "/" + regionEnum.getRegion());
            copyDir(file, file.getAbsolutePath() + "/", copyDest, regionEnum.getRegion());
            map.put(regionEnum, copyDestFile);
        }

        List<DockerJenkinsModel> models = Lists.newArrayList();
        for (DockerRegionEnum regionEnum : map.keySet()) {
            for (File listFile : Objects.requireNonNull(map.get(regionEnum).listFiles())) {
                models.addAll(readFirst(regionEnum, listFile));
            }
        }
        models.sort((o1, o2) -> NumberUtils.compare(o1.getIndex(), o2.getIndex()));
        Multimap<String, DockerJenkinsModel> multimap = ArrayListMultimap.create();
        models.forEach(model -> multimap.put(model.getRegion() + "_" + model.getPlatform(), model));
        models.forEach(model -> multimap.put(model.getPlatform(), model));
        multimap.asMap().forEach((regionPlat, dockerJenkinsModels) -> {
            writePlat(regionPlat, dockerJenkinsModels, true);
            //writePlat(regionPlat, dockerJenkinsModels, false);
        });
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

    private void writePlat(String plat, Collection<DockerJenkinsModel> models, boolean mix) {
        int multi = 10;
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
        String target = PathUtil.getTargetPath(plat + "_" + mix + ".sh");
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
                        Arrays.stream(versionSplits).forEach(new Consumer<>() {
                            @Override
                            public void accept(String version) {
                                Arrays.stream(plats).forEach(new Consumer<>() {
                                    @Override
                                    public void accept(String plat) {
                                        models.add(buildModel(path, plats, plat, version, enumMap, regionEnum.getRegion()));
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

    private DockerJenkinsModel buildModel(String path, String[] plats, String plat, String version, Map<BuildItemEnum, String> enumMap, String region) {
        DockerJenkinsModel model = new DockerJenkinsModel();
        model.setPath(path);
        model.setIndex(Integer.parseInt(enumMap.getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef())));
        //StringUtils.defaultIfBlank(enumMap.get(BuildItemEnum.REGION), PathBaseUtil.REGION);
        model.setHost(DockerRegionEnum.getRegion(region).getHost());
        model.setRegion(region);
        model.setPlatform(plat);
        model.setVersion(version);
        model.setPlatforms(plats);
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
