package com.k.docker.jenkins.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.k.docker.jenkins.consts.DockerConstans;
import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.docker.DockerConfigModel;
import com.k.docker.jenkins.model.docker.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.build.BuildItemEnum;
import com.k.docker.jenkins.model.emums.command.CommonPrefixEnum;
import com.k.docker.jenkins.model.emums.command.cmd.base.CmdTypeEnum;
import com.k.docker.jenkins.model.emums.command.cmd.base.CommonRunCmdEnum;
import com.k.docker.jenkins.model.emums.constant.ConstantEnum;
import com.k.docker.jenkins.model.emums.docker.DockerBuildPathEnum;
import com.k.docker.jenkins.model.emums.docker.DockerFunctionEnum;
import com.k.docker.jenkins.model.emums.docker.DockerParamEnum;
import com.k.docker.jenkins.model.emums.docker.DockerPlatformEnum;
import com.k.docker.jenkins.model.emums.docker.DockerRegionEnum;
import com.k.docker.jenkins.model.emums.git.GitRemoteEnum;
import com.k.docker.jenkins.model.emums.trans.FromTransEnum;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JenkinsUtil {


    Map<String, String> gitMap = Maps.newHashMap();

    public static String getVal(DockerParamEnum paramEnum, Map<DockerParamEnum, String> map) {
        return map.getOrDefault(paramEnum, paramEnum.getDef());
    }

    public static Integer getInt(DockerParamEnum paramEnum, Map<DockerParamEnum, String> map) {
        String val = map.getOrDefault(paramEnum, paramEnum.getDef());
        return Integer.parseInt(val);
    }

    public void jenkinsWrite(DockerConfigModel model) throws Exception {
        List<DockerJenkinsModel> models = null;
        for (DockerPlatformEnum platformEnum : DockerPlatformEnum.values()) {
            models = jenkinsWrite(model, platformEnum);
        }
        Set<String> regions = Sets.newHashSet();
        Objects.requireNonNull(models).forEach(jenkinsModel -> regions.add(jenkinsModel.getRegion().getRegion()));
        String dir = model.getDirPath();
        regions.forEach(region -> writePlat(dir, DockerBuildPathEnum.platform.getPath(), region, model.getMix()));
        //regions.forEach(region -> writePlat(dir, DockerBuildPathEnum.platform.getPath(), region, false));
    }

    public List<DockerJenkinsModel> jenkinsWrite(DockerConfigModel model, DockerPlatformEnum platform) throws Exception {
        String dockerDest = model.getBuildOutDest() + platform.getPlatform() + "/";
        List<DockerJenkinsModel> models = buildModel(dockerDest, model, platform);
        replaceDir(dockerDest, model);
        models = filter(models, model);
        models.sort((o1, o2) -> {
            int compare = NumberUtils.compare(o1.getIndex(), o2.getIndex());
            if (compare == 0) {
                compare = StringUtils.compare(o1.getVersions().get(0), o2.getVersions().get(0));
            }

            return compare;
        });
        writeNormal("", models, model, platform);
        return models;
    }

    public List<DockerJenkinsModel> buildModel(DockerConfigModel configModel, DockerPlatformEnum platform) throws Exception {
        String dockerDest = configModel.getBuildOutDest();
        configModel.setReplaceGit(true);
        configModel.setReplaceSetting(true);
        //configModel.setInDocker(true);
        return buildModel(dockerDest, configModel, platform);
    }

    public List<DockerJenkinsModel> buildModel(String dockerDest, DockerConfigModel configModel, DockerPlatformEnum platform) throws Exception {
        String resource = PathUtil.getResource(configModel.getBuildPath());
        File file = new File(resource);
        Map<DockerRegionEnum, File> map = Maps.newHashMap();
        copyFile(file, dockerDest, map, configModel, platform);
        List<DockerJenkinsModel> models = Lists.newArrayList();
        for (DockerRegionEnum regionEnum : map.keySet()) {
            for (File listFile : Objects.requireNonNull(map.get(regionEnum).listFiles())) {
                models.addAll(readFirst(regionEnum, listFile, configModel));
            }
        }
        return models;
    }

    private void replaceDir(String dockerDest, DockerConfigModel configModel) throws IOException {
        File dir = new File(PathUtil.getTargetPath(dockerDest));
        replaceHttp(dir, configModel);
    }

    private void replaceHttp(File dir, DockerConfigModel configModel) throws IOException {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                replaceHttp(file, configModel);
            } else if (file.getName().equals("Dockerfile")) {
                List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
                lines = replaceLines(lines, configModel);
                FileUtils.writeLines(file, lines);
            }
        }
    }

    private List<String> replaceLines(List<String> lines, DockerConfigModel configModel) {
        return lines.stream().map(new Function<String, String>() {
            @Override
            public String apply(String line) {
                line = line.trim();
                if (line.startsWith("ADD") && configModel.isReplaceDockerGit()) {
                    return startADD(line, configModel);
                }
                if (line.contains("git clone") && configModel.isReplaceDockerGit()) {
                    return startGitClone(line, configModel);
                }
                if (line.contains("FROM")) {
                    return startFROM(line, configModel);
                }
                return line;
            }
        }).collect(Collectors.toList());
    }

    private String startADD(String line, DockerConfigModel configModel) {
        String gitSave1 = "https://gitlab.com/king019/save_github/-/raw/main/";
        String gitSave2 = "http";
        String next = line;
        if (line.indexOf(gitSave1) > 0) {
            next = handleUrl(line, gitSave1, configModel);
        } else if (line.indexOf(gitSave2) > 0) {
            next = handleUrl(line, gitSave2, configModel);
        }
        return next;
    }

    private String startFROM(String line, DockerConfigModel configModel) {
        String start = "registry.cn-qingdao.aliyuncs.com/king019/";
        String next = line;
        String transFrom = configModel.getTransFrom();
        if (StringUtils.isNotBlank(transFrom) && line.indexOf(start) > 0) {
            String reg = FromTransEnum.getReg(transFrom);
            next = next.replace("registry.cn-qingdao.aliyuncs.com/", reg);
        }
        return next;
    }

    private String handleUrl(String line, String saveFilter, DockerConfigModel configModel) {
        int start = line.indexOf(saveFilter);
        int end = line.lastIndexOf(" ");
        String downUrl = line.substring(start, end);
        int lastIndexOf = downUrl.lastIndexOf("/");
        String fileName = downUrl.substring(lastIndexOf);
        int fileIndex = line.indexOf(fileName);
        String next = line.substring(fileIndex);
        next = "ADD " + PathBaseUtil.DOWN_PATH + next;
        System.out.println(next);
        return next;
    }

    private String startGitClone(String line, DockerConfigModel configModel) {
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

    private void writeNormal(String dir, List<DockerJenkinsModel> models, DockerConfigModel configModel, DockerPlatformEnum platform) {
        writeShell(dir, models, configModel, platform);
        // writeShell(dir, models, false,   configModel, platform);
    }

    private void writeShell(String dir, List<DockerJenkinsModel> models, DockerConfigModel configModel, DockerPlatformEnum platform) {
        String subDir = DockerBuildPathEnum.platform.getPath() + platform.getPlatform() + "/";
        Multimap<String, DockerJenkinsModel> multimap = ArrayListMultimap.create();
        Multimap<String, String> platformMap = HashMultimap.create();
        models.forEach(model -> multimap.put(model.getPlatform().getPlatform() + "_" + model.getRegion().getRegion(), model));
        models.forEach(model -> multimap.put(model.getPlatform().getPlatform(), model));
        models.forEach(model -> platformMap.put(model.getRegion().getRegion(), model.getPlatform().getPlatform() + "_" + model.getRegion().getRegion()));
        multimap.asMap().forEach((regionPlat, dockerJenkinsModels) -> {
            writePlat(dir, subDir, regionPlat, dockerJenkinsModels, configModel);
        });

    }

    private List<DockerJenkinsModel> filter(List<DockerJenkinsModel> models, DockerConfigModel model) {
        List<String> includes = model.getIncludes();
        List<String> excludes = model.getExcludes();
        if (CollectionUtils.isNotEmpty(includes)) {
            models = models.stream().filter(jenkinsModel -> {
                boolean exist = StringUtils.indexOfAny(jenkinsModel.getVersions().get(0), includes.stream().toArray(value -> new String[includes.size()])) >= 0;
                return exist;
            }).collect(Collectors.toList());
        }
        if (CollectionUtils.isNotEmpty(excludes)) {
            models = models.stream().filter(jenkinsModel -> {
                boolean exist = StringUtils.indexOfAny(jenkinsModel.getVersions().get(0), excludes.stream().toArray(value -> new String[excludes.size()])) >= 0;
                return !exist;
            }).collect(Collectors.toList());
        }
        models = models.stream().filter(jenkinsModel -> jenkinsModel.getIndex() > model.getMinIndex()).collect(Collectors.toList());
        models = models.stream().filter(jenkinsModel -> jenkinsModel.getIndex() < model.getMaxIndex()).collect(Collectors.toList());
        return models;
    }

    private void copyFile(File file, String dockerDest, Map<DockerRegionEnum, File> map, DockerConfigModel configModel, DockerPlatformEnum platform) throws Exception {
        for (String region : PathBaseUtil.REGIONS) {
            DockerRegionEnum regionEnum = DockerRegionEnum.getRegion(region);
            String copyDest = PathUtil.getTargetPath(dockerDest);
            File copyDestFile = new File(copyDest + "/" + regionEnum.getRegion());
            String buildDir = file.getAbsolutePath() + "/";
            copyDir(file, buildDir, copyDest, regionEnum.getRegion(), configModel, platform);
            map.put(regionEnum, copyDestFile);
        }
    }

    private void copyDir(File dir, String buildDir, String dest, String region, DockerConfigModel configModel, DockerPlatformEnum platform) throws Exception {
        File[] files = dir.listFiles();
        List<File> fileList = new ArrayList<>();
        List<String> exDirs = configModel.getExcludeBaseDirs();
        for (File file : files) {
            boolean filter = false;
            for (String exDir : exDirs) {
                if (StringUtils.equals(file.getName(), exDir)) {
                    filter = true;
                }
            }
            if (!filter) {
                fileList.add(file);
            }
        }
        for (File listFile : fileList.stream().sorted().toList()) {
            if (dir.getName().equals("nouse")) {
                continue;
            }
            if (listFile.getName().equals("pull")) {
                copyDirPull(listFile, buildDir, dest, region, configModel);
                continue;
            }

            if (listFile.isFile()) {
                copyFile(listFile, buildDir, dest, region, configModel, platform);
            } else {
                copyDir(listFile, buildDir, dest, region, configModel, platform);
            }
        }
    }

    private void copyDirPull(File dir, String src, String dest, String region, DockerConfigModel configModel) throws Exception {
        for (File listFile : Objects.requireNonNull(dir.listFiles())) {
            if (listFile.isFile()) {
                copyFilePull(listFile, src, dest, region, configModel);
            } else {
                copyDirPull(listFile, src, dest, region, configModel);
            }
        }
    }

    private void copyFilePull(File srcfile, String src, String dest, String region, DockerConfigModel configModel) throws Exception {
        String absolutePath = srcfile.getAbsolutePath();
        absolutePath = absolutePath.replace(src, dest + region + "/");
        File destfile = new File(absolutePath);
        copyFilePull(srcfile, destfile, region, configModel);
    }

    private void copyFilePull(File srcfile, File destfile, String region, DockerConfigModel configModel) throws Exception {
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
                        writeDef(dir, version, configModel);
                    }
                }
            }
        }
    }

    private void writeDef(String dir, String version, DockerConfigModel configModel) throws Exception {
        dir = dir + "/buildshell/docker";
        File function = new File(dir + "/function.txt");
        FileUtils.writeLines(function, Lists.newArrayList("only_local"));
        File platform = new File(dir + "/platform.txt");
        FileUtils.writeLines(platform, Lists.newArrayList("aarch64", "x86_64"));
        File versionFile = new File(dir + "/version.txt");
        FileUtils.writeLines(versionFile, Lists.newArrayList(version));
    }

    private void copyFile(File srcfile, String buildDir, String dest, String region, DockerConfigModel configModel, DockerPlatformEnum platform) throws Exception {
        String absolutePath = srcfile.getAbsolutePath();
        String destDir = dest + region + "/";
        absolutePath = absolutePath.replace(buildDir, dest + region + "/");
        File destfile = new File(absolutePath);
        copyFile(srcfile, destfile, buildDir, destDir, region, configModel, platform);
    }

    private void copyFile(File srcfile, File destfile, String buildDir, String destDir, String region, DockerConfigModel configModel, DockerPlatformEnum platform) throws Exception {
        String hostBase = DockerRegionEnum.getRegion(region).getHost();
        List<String> lines = FileUtils.readLines(srcfile, StandardCharsets.UTF_8);
        if (CollectionUtils.isNotEmpty(lines)) {
            if (srcfile.getName().equals("Dockerfile")) {
//                for (int i = lines.size() - 1; i >= 0; i--) {
//                    handleDockerDkMultiConfigCopy(lines, i, configModel);
//                }
                for (int i = lines.size() - 1; i >= 0; i--) {
                    handleDockerFileFrom(hostBase, lines, configModel, platform, i);
                    handleDockerRunCmdCopy(destfile, lines, destDir, i, configModel);
//                    handleDockerRunFileCopy(srcfile, destfile, lines, buildDir, i);
//                    handleDockerMultiFileCopy(srcfile, destfile, lines, buildDir, i, configModel);
//                    handleDockerMultiDirCopy(lines, i);
//                    handleDockerMultiMirrorCopy(lines, i, configModel);
                }
            } else if (srcfile.getName().endsWith(".sh")) {
                for (int i = lines.size() - 1; i >= 0; i--) {
                    judgeGit(srcfile, lines, i, configModel);
                }
            }
        }
        FileUtils.writeLines(destfile, lines);
    }

    private void handleDockerFileFrom(String hostBase, List<String> lines, DockerConfigModel configModel, DockerPlatformEnum platform, int i) {
        String host = hostBase;
        String from = lines.get(i);
        if (!from.startsWith("FROM")) {
            return;
        }
        if (from.contains(DockerRegionEnum.QING_DAO.getHost())) {
            return;
        }
        String prefix = "king019/";
        int index = from.indexOf(prefix);
        if (index > 0) {
            lines.remove(i);
            if (StringUtils.isNotBlank(host)) {
                host = host + "/" + from.substring(index);
            } else {
                host = host + from.substring(index);
            }
            from = from.substring(0, index) + host;
            if (configModel.isSuffix()) {
                if (from.indexOf(":") > 0) {
                    from = from + platform.getFromSplit() + platform.getPlatform();
                } else {
                    from = from + ":" + platform.getPlatform();
                }
            }
            lines.add(i, from);
        }
    }

    private void handleDockerRunCmdCopy(File destfile, List<String> lines, String destDir, int i, DockerConfigModel configModel) {
        String from = lines.get(i);
        String prefix = CommonPrefixEnum.multi_run_cmd.getCode();
        if (!from.startsWith(prefix)) {
            return;
        }

        int index = from.indexOf(prefix) + prefix.length();
        String sub = from.substring(index).trim();
        List<CmdModel> multiItems = Lists.newArrayList(CommonRunCmdEnum.getMultiItem(sub));
        lines.remove(i);
        Collections.reverse(multiItems);
        for (CmdModel runCmdEnum : multiItems) {
            CmdTypeEnum cmdType = runCmdEnum.getCmdType();
//            String cmd = CommonPrefixEnum.multi_run_cmd.getCmd();
            String cmdPre = runCmdEnum.getCmdPre();
//            StringUtils.defaultIfBlank(runCmdEnum.getCmdPre(), cmd);
            String cmd = null;
            switch (cmdType) {
                case mirror:
                    boolean replaceTxt = configModel.isReplaceTxt();
                    if (!replaceTxt) {
                        cmd = runCmdEnum.getCmdSrc();
                    } else {
                        cmd = StringUtils.defaultIfBlank(runCmdEnum.getCmdDest(), runCmdEnum.getCmdSrc());
                    }
                    lines.add(i, cmdPre + " " + cmd);
                    break;
            }

        }
    }
//
//
//    private void handleConfigFileItem(CopyTypeEnum copy, String copyFile, String destFile, String
//            srcFile, List<String> lines, int i, String buildDir, File destfile) {
//        String src = buildDir + srcFile;
//        switch (copy) {
//            case copy_file:
//                lines.add(i, "COPY " + copyFile + " " + destFile);
//                File nowDir = destfile.getParentFile();
//                String dest = nowDir.getAbsolutePath() + "/" + copyFile;
//                copyRealFile(src, dest);
////                lines.add(i, "ADD file://" + src + " " + destFile);
//                break;
//            case copy_txt:
//                handleConfigFileItem(i, src, lines, destFile);
//                break;
//        }
//
//    }

    @SneakyThrows
    private void handleConfigFileItem(int i, String src, List<String> lines, String destFile) {
        List<String> fileLines = FileUtils.readLines(new File(src), Charset.defaultCharset());
        String line = StringUtils.join(fileLines, "\\n");
        String start = "'";
        if (!StringUtils.contains(line, "\"")) {
            start = "\"";
        }
        if (StringUtils.contains(line, "'") && StringUtils.contains(line, "\"")) {
            throw new RuntimeException(line);
        }

        lines.add(i, "RUN echo -e " + start + "" + line + start + " > " + destFile);
    }


//    @SneakyThrows
//    private void handleConfigFileItem(int i, String src, List<String> lines, String destFile) {
//        lines.add(i, "EOF");
//               List<String> fileLines = FileUtils.readLines(new File(src), Charset.defaultCharset());
//       String line = StringUtils.join(fileLines, "\\n");
//        lines.add(i, line);
//        lines.add(i, "RUN cat <<EOF > " + destFile);
//    }


//    @SneakyThrows
//    private void handleConfigFileItem(int i, String src, List<String> lines, String destFile) {
//        List<String> fileLines = FileUtils.readLines(new File(src), Charset.defaultCharset());
//        lines.add(i, "EOF");
//        fileLines = new ArrayList<>(fileLines);
//        Collections.reverse(fileLines);
//        //        List<String> fileLines = FileUtils.readLines(new File(src), Charset.defaultCharset());
////        String line = StringUtils.join(fileLines, "\\n");
//        for (String fileLine : fileLines) {
//            lines.add(i, fileLine);
//        }
//        lines.add(i, "RUN cat <<EOF > " + destFile);
//    }

//
//    @SneakyThrows
//    private void copyRealFile(String src, String dest) {
////        Path sourcePath = Paths.get(src);
////        Path destinationPath = Paths.get(dest);
////        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
//        FileUtils.copyFile(new File(src), new File(dest), true);
//    }


    private void writePlat(String dir, String subDir, String
            plat, Collection<DockerJenkinsModel> models, DockerConfigModel configModel) {
        List<String> lines = Lists.newArrayList();
        lines.add("#!/bin/sh");
        lines.add("set -x");
        Map<Integer, List<DockerJenkinsModel>> map = models.stream().collect(Collectors.groupingBy(DockerJenkinsModel::getIndex));
        buildBuildLines(lines, map, (strings, model) -> {
            lines.add(model.buildBuild());
            if (configModel.isPush()) {
                lines.add(model.buildPush());
            }
            if (configModel.getMix()) {
                lines.add(model.getMap().get(model.getPlatform()));
            }
        }, configModel);
        String target = PathUtil.getTargetPath(dir + subDir + plat + "_" + configModel.getMix() + ".sh");
        File targetFile = new File(target);
        try {
            FileUtils.writeLines(targetFile, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writePlat(String dir, String subDir, String region, boolean mix) {
        boolean bash = true;
        String prefix = bash ? "[[" : "[";
        String subfix = bash ? "]]" : "]";
        List<String> lines = Lists.newArrayList();
        lines.add("#!/bin/bash");
        lines.add("set -x");
        lines.add("NowPlatform=$(uname -m)");
        lines.add("X86='" + DockerPlatformEnum.ADM64.getPlatform() + "'");
        lines.add("Arm='" + DockerPlatformEnum.ARM64.getPlatform() + "'");
        lines.add("if " + prefix + " $NowPlatform == $X86 " + subfix);
        //lines.add("if [[ $NowPlatform == *$X86* ]]");
        lines.add("then");
//        for (String platRegion : Sets.newHashSet(platformMap.get(region))) {
//            if (platRegion.contains(DockerPlatformEnum.ADM64.getPlatform())) {
        String name = dir + subDir + DockerPlatformEnum.ADM64.getPlatform() + "/" + DockerPlatformEnum.ADM64.getPlatform() + "_" + region + "_" + mix + ".sh";
        lines.add(name);
//            }
//        }
        lines.add("else " + prefix + " $NowPlatform == $Arm " + subfix + "");
        //lines.add("else [[ $NowPlatform == *$Arm* ]]");
//        for (String platRegion : Sets.newHashSet(platformMap.get(region))) {
//            if (platRegion.contains(DockerPlatformEnum.ARM64.getPlatform())) {
        name = dir + subDir + DockerPlatformEnum.ARM64.getPlatform() + "/" + DockerPlatformEnum.ARM64.getPlatform() + "_" + region + "_" + mix + ".sh";
        lines.add(name);
//            }
//        }
        lines.add("fi");

        String target = PathUtil.getTargetPath(dir + region + "_" + mix + ".sh");
        File targetFile = new File(target);
        try {
            FileUtils.writeLines(targetFile, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildBuildLines
            (List<String> lines, Map<Integer, List<DockerJenkinsModel>> map, BiConsumer<List<String>, DockerJenkinsModel> consumer, DockerConfigModel
                    configModel) {
        List<Integer> indexs = Lists.newArrayList(map.keySet());
        Collections.sort(indexs);
        for (Integer index : indexs) {
            List<DockerJenkinsModel> indexModels = map.get(index);
            indexModels.sort((o1, o2) -> StringUtils.compare(o1.getVersions().get(0), o2.getVersions().get(0)));
            List<List<DockerJenkinsModel>> partitionss = Lists.partition(indexModels, configModel.getMulti());
            for (List<DockerJenkinsModel> partitions : partitionss) {
                for (DockerJenkinsModel model : partitions) {
                    model.setUseCache(configModel.isUseCache());
                    model.setSuffix(configModel.isSuffix());
                    lines.add("{");
                    consumer.accept(lines, model);
                    lines.add("}&");
                }
                lines.add("wait");
                if (configModel.isPrune()) {
                    lines.addAll(DockerConstans.prunes);
//                    lines.add("docker image prune -a -f");
                }
                //lines.add("sleep 1");
            }
        }
    }

    private List<DockerJenkinsModel> readFirst(DockerRegionEnum regionEnum, File file, DockerConfigModel
            configModel) throws Exception {
        Map<String, Map<String, Map<BuildItemEnum, String>>> map = Maps.newLinkedHashMap();
        readDir(file, map, configModel);
        return writeLines(regionEnum, map, file, configModel);
    }

    private List<DockerJenkinsModel> writeLines(DockerRegionEnum
                                                        regionEnum, Map<String, Map<String, Map<BuildItemEnum, String>>> map, File firstFile, DockerConfigModel
                                                        configModel) {
        List<DockerJenkinsModel> models = Lists.newArrayList();
        map.forEach((path, pathMap) -> pathMap.forEach((nextPath, enumMap) -> {
            if (Objects.nonNull(enumMap.get(BuildItemEnum.IGNORE))) {
                return;
            }
            String versions = enumMap.get(BuildItemEnum.VERSION);
            if (StringUtils.isBlank(versions)) {
                return;
            }
            String[] plats = getPlat(firstFile, enumMap, configModel);
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
            Arrays.stream(plats).forEach(new Consumer<>() {
                @Override
                public void accept(String plat) {
                    models.add(buildModel(path, plats, plat, versionSplits, enumMap, regionEnum.getRegion(), ignoreRegionSplits, functionSplits, configModel));
                }
            });
//            Arrays.stream(versionSplits).forEach(new Consumer<>() {
//                @Override
//                public void accept(String version) {
//                    Arrays.stream(plats).forEach(new Consumer<>() {
//                        @Override
//                        public void accept(String plat) {
//                            models.add(buildModel(path, plats, plat, version, enumMap, regionEnum.getRegion(), ignoreRegionSplits, functionSplits, configModel));
//                        }
//                    });
//                }
//            });
        }));
        return models;
    }

    private DockerJenkinsModel buildModel(String path, String[] plats, String plat, String[]
            versions, Map<BuildItemEnum, String> enumMap, String
                                                  region, Set<String> ignoreRegions, Set<String> functionSplits, DockerConfigModel configModel) {
        DockerJenkinsModel model = new DockerJenkinsModel();
        model.setPath(path);
        model.setIndex(Integer.parseInt(enumMap.getOrDefault(BuildItemEnum.INDEX, BuildItemEnum.INDEX.getDef())));
        //StringUtils.defaultIfBlank(enumMap.get(BuildItemEnum.REGION), PathBaseUtil.REGION);
        //model.setHost(DockerRegionEnum.getRegion(region).getHost());
        model.setRegion(DockerRegionEnum.getRegion(region));
        model.setPlatform(DockerPlatformEnum.getPlatform(plat));
        model.setVersions(Arrays.stream(versions).toList());
        model.setPlatforms(DockerPlatformEnum.getPlatforms(plats));
        model.setIgnoreRegions(DockerRegionEnum.getRegions(ignoreRegions));
        model.setFunctions(DockerFunctionEnum.getFunctions(functionSplits));
        List<String> dockerLines = null;
        try {
            dockerLines = FileUtils.readLines(new File(path + "/Dockerfile"), StandardCharsets.UTF_8);
            model.setDockerLines(dockerLines);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return model;
    }

    private String[] getPlat(File firstFile, Map<BuildItemEnum, String> enumMap, DockerConfigModel configModel) {
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

    private void readDir(File
                                 file, Map<String, Map<String, Map<BuildItemEnum, String>>> map, DockerConfigModel configModel) throws
            Exception {
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
                int prePathIndex = path.indexOf(configModel.getBuildOut());
                path = path.substring(prePathIndex);
                Map<String, Map<BuildItemEnum, String>> pathMap = map.computeIfAbsent(path, s -> Maps.newHashMap());
                Map<BuildItemEnum, String> enumMap = pathMap.computeIfAbsent(pathNext, nextPath -> Maps.newHashMap());
                enumMap.put(item, doc);
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (Optional.ofNullable(files).isPresent()) {
                for (File fileInner : files) {
                    readDir(fileInner, map, configModel);
                }
            }
        }
    }

    private void judgeGit(File srcfile, List<String> lines, int index, DockerConfigModel configModel) {
        if (!configModel.isReplaceGit()) {
            return;
        }
        if (srcfile.getAbsolutePath().contains("/source/")) {
            return;
        }
        String cmd = lines.get(index);
        if (StringUtils.startsWith(cmd, "git clone http")) {
            cmd = cmd.substring(10);
            String des = GitRemoteEnum.getDes(cmd);
            //if(!cmd.equals(des)){
            gitMap.put(cmd, des);
            //}
            lines.set(index, replaceGit(cmd, des, configModel));
        }
    }


    private String replaceGit(String src, String des, DockerConfigModel configModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("if git ls-remote ").append(des).append(" > /dev/null; then ");
        sb.append(ConstantEnum.HUANHANG.getCode());
        sb.append("git clone ").append(des);
        sb.append(ConstantEnum.HUANHANG.getCode());
        sb.append("else");
        sb.append(ConstantEnum.HUANHANG.getCode());
        sb.append("git clone ").append(src);
        sb.append(ConstantEnum.HUANHANG.getCode());
        sb.append("fi");
        return sb.toString();
    }

}
