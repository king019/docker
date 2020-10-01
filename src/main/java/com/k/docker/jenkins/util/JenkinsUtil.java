package com.k.docker.jenkins.util;

import com.google.common.collect.*;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JenkinsUtil {
    public static String getVal(DockerParamEnum paramEnum, Map<DockerParamEnum, String> map) {
        return map.getOrDefault(paramEnum, paramEnum.getDef());
    }

    public void jenkinsWrite(int multi, List<String> includes, List<String> excludes, boolean replace, boolean push) throws Exception {
        jenkinsWrite(multi, includes, excludes, replace, push, true, true);
    }

    public void jenkinsWrite(int multi, List<String> includes, List<String> excludes, boolean replace, boolean push, boolean inDocker, boolean localRegion ) throws Exception {
        String dockerDest = "dockerDest/";
        List<DockerJenkinsModel> models = buildModel(dockerDest, inDocker);
        replaceDir(dockerDest, replace);
        models = filter(models, includes, excludes);
        models.sort((o1, o2) -> NumberUtils.compare(o1.getIndex(), o2.getIndex()));
        writeNormal("", models, true, multi, push);
        if (localRegion) {
            writeLocal(DockerRegionEnum.LOCAL, models, false, multi, push);
        }

    }

    public List<DockerJenkinsModel> buildModel() throws Exception {
        String dockerDest = "dockerDest/";
        return buildModel(dockerDest, true);
    }

    public List<DockerJenkinsModel> buildModel(String dockerDest, boolean inDocker) throws Exception {
        String resource = PathUtil.getResource("build");
        File file = new File(resource);
        Map<DockerRegionEnum, File> map = Maps.newHashMap();
        copyFile(file, dockerDest, map);
        List<DockerJenkinsModel> models = Lists.newArrayList();
        for (DockerRegionEnum regionEnum : map.keySet()) {
            if (!inDocker) {
                if (regionEnum.equals(DockerRegionEnum.DOCKER)) {
                    continue;
                }
            }
            for (File listFile : Objects.requireNonNull(map.get(regionEnum).listFiles())) {
                models.addAll(readFirst(regionEnum, listFile));
            }
        }
        return models;
    }

    private void replaceDir(String dockerDest, boolean replace) throws IOException {
        if (!replace) {
            return;
        }
        File dir = new File(PathUtil.getTargetPath(dockerDest));
        replaceHttp(dir);
    }

    private void replaceHttp(File dir) throws IOException {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                replaceHttp(file);
            } else if (file.getName().equals("Dockerfile")) {
                List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
                lines = replaceLines(lines);
                FileUtils.writeLines(file, lines);
            }
        }
    }

    private List<String> replaceLines(List<String> lines) {
        return lines.stream().map(new Function<String, String>() {
            @Override
            public String apply(String line) {
                line = line.trim();
                if (line.startsWith("ADD")) {
                    return startADD(line);
                }
                if (line.contains("git clone")) {
                    return startGitClone(line);
                }
                return line;
            }
        }).collect(Collectors.toList());
    }

    private String startADD(String line) {
        String gitSave1 = "https://raw.githubusercontent.com/king019/";
        String gitSave2 = "http";
        String next = line;
        if (line.indexOf(gitSave1) > 0) {
            next = handleUrl(line, gitSave1);
        } else if (line.indexOf(gitSave2) > 0) {
            next = handleUrl(line, gitSave2);
        }
        return next;
    }

    private String handleUrl(String line, String saveFilter) {
        int start = line.indexOf(saveFilter);
        int end = line.lastIndexOf(" ");
        String downUrl = line.substring(start, end);
        int lastIndexOf = downUrl.lastIndexOf("/");
        String fileName = downUrl.substring(lastIndexOf);
        int fileIndex = line.indexOf(fileName);
        String next = line.substring(fileIndex);
        next = "ADD http://nginxdown:9500" + next;
        return next;
    }

    private String startGitClone(String line) {
        if (line.contains("git clone")) {
            line = line.trim();
            int start = line.indexOf("git clone") + 9;
            int end = line.lastIndexOf(".git") + 4;
            String gitAddr = line.substring(start, end).trim();
            int lastIndexOf = gitAddr.lastIndexOf("/");
            String replceDir = gitAddr.substring(lastIndexOf);
            replceDir = "http://gitea:3000/king019" + replceDir;
            line = line.replace(gitAddr, replceDir);
            return line;
        }
        return line;
    }

    private List<DockerJenkinsModel> filterNormal(List<DockerJenkinsModel> models) {
        return models.stream().filter(model -> !DockerRegionEnum.filterSpecile(model.getRegion())).collect(Collectors.toList());
    }

    private List<DockerJenkinsModel> filterSpecial(List<DockerJenkinsModel> models) {
        return models.stream().filter(model -> DockerRegionEnum.filterSpecile(model.getRegion())).collect(Collectors.toList());
    }

    private void writeLocal(DockerRegionEnum regionEnum, List<DockerJenkinsModel> models, boolean mix, int multi, boolean push) {
        models = filterSpecial(models);
        models = models.stream().filter(model -> DockerPlatformEnum.ADM64.equals(model.getPlatform())).map(model -> {
            model.setPlatforms(ImmutableSet.of());
            model.setPlatform(DockerPlatformEnum.NO_SUFFIX);
            return model;
        }).filter(model -> {
            Set<DockerRegionEnum> ignoreRegions = model.getIgnoreRegions();
            if (CollectionUtils.isNotEmpty(ignoreRegions)) {
                return !ignoreRegions.contains(model.getRegion());
            } else {
                return true;
            }
        }).collect(Collectors.toList());
        writeShell(regionEnum.getRegion() + "/", models, mix, multi, push);
    }

    private void writeNormal(String dir, List<DockerJenkinsModel> models, boolean mix, int multi, boolean push) {
        models = filterNormal(models);
        models = models.stream().filter(model -> !model.getFunctions().contains(DockerFunctionEnum.ONLY_LOCAL)).collect(Collectors.toList());
        writeShell(dir, models, mix, multi, push);
    }

    private void writeShell(String dir, List<DockerJenkinsModel> models, boolean mix, int multi, boolean push) {
        Multimap<String, DockerJenkinsModel> multimap = ArrayListMultimap.create();
        models.forEach(model -> multimap.put(model.getPlatform().getPlatform() + "_" + model.getRegion().getRegion(), model));
        models.forEach(model -> multimap.put(model.getPlatform().getPlatform(), model));
        multimap.asMap().forEach((regionPlat, dockerJenkinsModels) -> {
            writePlat(dir, regionPlat, dockerJenkinsModels, mix, multi, push);
            //writePlat(regionPlat, dockerJenkinsModels, false);
        });
    }

    private List<DockerJenkinsModel> filter(List<DockerJenkinsModel> models, List<String> includes, List<String> excludes) {
        if (CollectionUtils.isNotEmpty(includes)) {
            models = models.stream().filter(model -> {
                boolean exist = StringUtils.indexOfAny(model.getVersion(), includes.stream().toArray(value -> new String[includes.size()])) > 0;
                return exist;
            }).collect(Collectors.toList());
        }
        if (CollectionUtils.isNotEmpty(excludes)) {
            models = models.stream().filter(model -> {
                boolean exist = StringUtils.indexOfAny(model.getVersion(), excludes.stream().toArray(value -> new String[excludes.size()])) > 0;
                return !exist;
            }).collect(Collectors.toList());
        }
        return models;
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
            if (listFile.getName().equals("pull")) {
                copyDirPull(listFile, src, dest, region);
                continue;
            }
            if (listFile.isFile()) {
                copyFile(listFile, src, dest, region);
            } else {
                copyDir(listFile, src, dest, region);
            }
        }
    }

    private void copyDirPull(File dir, String src, String dest, String region) throws Exception {
        for (File listFile : Objects.requireNonNull(dir.listFiles())) {
            if (listFile.isFile()) {
                copyFilePull(listFile, src, dest, region);
            } else {
                copyDirPull(listFile, src, dest, region);
            }
        }
    }

    private void copyFilePull(File srcfile, String src, String dest, String region) throws Exception {
        String absolutePath = srcfile.getAbsolutePath();
        absolutePath = absolutePath.replace(src, dest + region + "/");
        File destfile = new File(absolutePath);
        copyFilePull(srcfile, destfile, region);
    }

    private void copyFilePull(File srcfile, File destfile, String region) throws Exception {
        List<String> lines = FileUtils.readLines(srcfile, StandardCharsets.UTF_8);
        if (CollectionUtils.isNotEmpty(lines)) {
            if (srcfile.getName().equals("Dockerfile")) {
                for (String line : lines) {
                    if (line.startsWith("FROM")) {
                        String version = line.replace("FROM", "").trim();
                        version = version.replace(":", "_");
                        String fileName = version.replace("/", "_");
                        version = "king019/mydocker_" + version.replace("/", "_") + ":docker";
                        List<String> innerLines = Lists.newArrayList(line);
                        innerLines.add("MAINTAINER king019");
                        String dir = destfile.getParent() + "/" + fileName;
                        File newFile = new File(destfile.getParent() + "/" + fileName + "/Dockerfile");
                        FileUtils.writeLines(newFile, innerLines);
                        writeDef(dir, version);
                    }
                }
            }
        }
    }

    private void writeDef(String dir, String version) throws Exception {
        dir = dir + "/buildshell/docker";
        File function = new File(dir + "/function.txt");
        FileUtils.writeLines(function, Lists.newArrayList("only_local"));
        File platform = new File(dir + "/platform.txt");
        FileUtils.writeLines(platform, Lists.newArrayList("aarch64", "x86_64"));
        File versionFile = new File(dir + "/version.txt");
        FileUtils.writeLines(versionFile, Lists.newArrayList(version));

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

    private void writePlat(String dir, String plat, Collection<DockerJenkinsModel> models, boolean mix, int multi, boolean push) {
        List<String> lines = Lists.newArrayList();
        lines.add("#!/bin/sh");
        lines.add("set -x");
        Map<Integer, List<DockerJenkinsModel>> map = models.stream().collect(Collectors.groupingBy(DockerJenkinsModel::getIndex));
        buildBuildLines(lines, map, multi, (strings, model) -> {
            lines.add(model.buildBuild());
            if (push) {
                lines.add(model.buildPush());
            }
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
                        Set<String> ignoreRegionSplits = Sets.newHashSet();
                        String ignoreRegion = enumMap.get(BuildItemEnum.IGNORE_REGION);
                        if (StringUtils.isNotBlank(ignoreRegion)) {
                            ignoreRegionSplits.addAll(Sets.newHashSet(StringUtils.split(ignoreRegion, ",")));
                        }
                        Set<String> functionSplits = Sets.newHashSet();
                        {

                            String functions = enumMap.get(BuildItemEnum.FUNCTION);
                            if (StringUtils.isNotBlank(functions)) {
                                functionSplits.addAll(Sets.newHashSet(StringUtils.split(functions, ",")));
                            }

                        }


                        Arrays.stream(versionSplits).forEach(new Consumer<>() {
                            @Override
                            public void accept(String version) {
                                Arrays.stream(plats).forEach(new Consumer<>() {
                                    @Override
                                    public void accept(String plat) {
                                        models.add(buildModel(path, plats, plat, version, enumMap, regionEnum.getRegion(), ignoreRegionSplits, functionSplits));
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

    private DockerJenkinsModel buildModel(String path, String[] plats, String plat, String version, Map<BuildItemEnum, String> enumMap, String region, Set<String> ignoreRegions, Set<String> functionSplits) {
        DockerJenkinsModel model = new DockerJenkinsModel();
        model.setPath(path);
        model.setIndex(Integer.parseInt(enumMap.getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef())));
        //StringUtils.defaultIfBlank(enumMap.get(BuildItemEnum.REGION), PathBaseUtil.REGION);
        //model.setHost(DockerRegionEnum.getRegion(region).getHost());
        model.setRegion(DockerRegionEnum.getRegion(region));
        model.setPlatform(DockerPlatformEnum.getPlatform(plat));
        model.setVersion(version);
        model.setPlatforms(DockerPlatformEnum.getPlatforms(plats));
        model.setIgnoreRegions(DockerRegionEnum.getRegions(ignoreRegions));
        model.setFunctions(DockerFunctionEnum.getFunctions(functionSplits));
        List<String> dockerLines = null;
        try {
            dockerLines = FileUtils.readLines(new File(path + "/Dockerfile"), StandardCharsets.UTF_8);
            model.setDockerLines(dockerLines);
        } catch (IOException e) {
        }

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
