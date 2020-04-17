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
import org.apache.commons.io.FileUtils;
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
        List<DockerJenkinsModel> models = Lists.newArrayList();
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            models.addAll(writeFirst(listFile));
        }
        models.sort((o1, o2) -> NumberUtils.compare(o1.getIndex(), o2.getIndex()));
        Multimap<String, DockerJenkinsModel> multimap = ArrayListMultimap.create();
        models.forEach(model -> multimap.put(model.getPlatform(), model));
        multimap.asMap().forEach((plat, dockerJenkinsModels) -> {
            writePlat(plat, dockerJenkinsModels, true);
            writePlat(plat, dockerJenkinsModels, false);
        });

    }

    private void writePlat(String plat, Collection<DockerJenkinsModel> models, boolean mix) {
        List<String> lines = Lists.newArrayList();
        lines.add("#!/bin/sh");
        for (DockerJenkinsModel model : models) {
            lines.add(model.toString());
        }
        for (DockerJenkinsModel model : models) {
            if (mix) {
                lines.add(model.getMap().get(model.getPlatform()));
            }
        }
        String target = PathUtil.getTargetPath(plat + "_" + mix + ".sh");
        File targetFile = new File(target);
        try {
            FileUtils.writeLines(targetFile, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<DockerJenkinsModel> writeFirst(File file) throws Exception {
        Map<String, Map<String, Map<BuildItemEnum, String>>> map = Maps.newLinkedHashMap();
        readDir(file, map);
        return writeLines(map, file);
    }

    private List<DockerJenkinsModel> writeLines(Map<String, Map<String, Map<BuildItemEnum, String>>> map, File firstFile) {
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
                                        models.add(buildModel(path, plats, plat, version, enumMap));
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

    private DockerJenkinsModel buildModel(String path, String[] plats, String plat, String version, Map<BuildItemEnum, String> enumMap) {
        DockerJenkinsModel model = new DockerJenkinsModel();
        model.setPath(path);
        model.setIndex(Integer.parseInt(enumMap.getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef())));
        model.setHost(DockerRegionEnum.getRegion(enumMap.get(BuildItemEnum.REGION)).getHost());
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
