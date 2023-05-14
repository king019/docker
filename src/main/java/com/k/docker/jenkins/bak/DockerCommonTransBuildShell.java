package com.k.docker.jenkins.bak;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.dep.common.util.FWPathUtil;
import com.k.docker.jenkins.model.DockerConfigModel;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.BuildItemEnum;
import com.k.docker.jenkins.model.emums.DockerBuildPathEnum;
import com.k.docker.jenkins.model.emums.DockerPlatformEnum;
import com.k.docker.jenkins.model.emums.DockerRegionEnum;
import com.k.docker.jenkins.util.PathUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DockerCommonTransBuildShell {
    private Set<String> regSet = Set.of(
            "registry.cn-hangzhou.aliyuncs.com",
            "registry.cn-beijing.aliyuncs.com",
            "swr.cn-east-2.myhuaweicloud.com",
            "registry.gitlab.cn",
            "ghcr.io"
    );
    private String targetReg = "registry.cn-qingdao.aliyuncs.com/king019";
    private String ignore = "@ignore";
    private String ignoreDk = "@ignoreDk";

    private int maxStep = 20;
    private int defStep = 1;
    private boolean arm = true;
    private boolean subFix = true;
    private boolean parll = true;
    private boolean manifest = true;


    @Test
    public void test() throws Exception {
        String targetAliyunPath = FWPathUtil.getTargetPath("pull/aliyun_qingdao.sh");
        List<String> lines = readFrom();
        lines = lines.stream().filter(s -> !StringUtils.startsWith(s, "#")).toList();
        List<String> targetAliyunLines = Lists.newArrayList();
        aliyun(lines, targetAliyunLines, targetReg);
        FileUtils.writeLines(new File(targetAliyunPath), targetAliyunLines);
    }


    public List<String> readFrom() throws Exception {
        String resource = PathUtil.getResource("build/common");
        File file = new File(resource);
        List<String> froms = new ArrayList<>();
        readFrom(file, froms);
        return List.copyOf(Set.copyOf(froms));
    }

    private void readFrom(File file, List<String> froms) throws Exception {

        for (File listFile : file.listFiles()) {
            if (listFile.isFile()) {

                if (listFile.getName().equals("Dockerfile")) {
                    List<String> lines = FileUtils.readLines(listFile, Charset.defaultCharset());
                    List<String> collect = lines.stream()
                            .filter(new Predicate<String>() {
                                @Override
                                public boolean test(String line) {
                                    return line.contains("FROM");
                                }
                            }).filter(new Predicate<String>() {
                                @Override
                                public boolean test(String line) {
                                    return !line.contains("king019");
                                }
                            }).filter(new Predicate<String>() {
                                @Override
                                public boolean test(String line) {
                                    return !line.contains("#");
                                }
                            })
                            .map(new Function<String, String>() {
                                @Override
                                public String apply(String line) {
                                    return line.replace("FROM", "").trim();
                                }
                            })
                            .collect(Collectors.toList());
                    froms.addAll(collect);
                }


            } else {
                readFrom(listFile, froms);
            }
        }
    }

    private void aliyun(List<String> lines, List<String> targetDkLines, String dockerHost) {
        //dk
        int step = defStep;
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignoreDk)) {
                break;
            }


            if (parll) {
                targetDkLines.add("{");
            }

            String source = line;
            String transSource = line;
            if (StringUtils.contains(transSource, "/")) {
                transSource = transSource.replace("/", "_");
            }

            String target;
            targetDkLines.add("echo '" + line + "'");
            targetDkLines.add("docker pull " + line);
            for (String reg : regSet) {
                transSource = StringUtils.replace(transSource, reg + "/", "");
            }
            String targetX86 = dockerHost + "/" + addSub(transSource, DockerPlatformEnum.ADM64.getPlatform(), subFix);
            String targetArm64 = dockerHost + "/" + addSub(transSource, DockerPlatformEnum.ARM64.getPlatform(), subFix);
            target = dockerHost + "/" + transSource;
            targetDkLines.add("docker tag " + source + " " + targetX86);
            targetDkLines.add("docker push " + targetX86);
            if (arm) {
                targetDkLines.add("docker tag " + source + " " + targetArm64);
                targetDkLines.add("docker push " + targetArm64);
            }
            if (manifest) {
                manifest(target, targetX86, targetArm64, targetDkLines);
            }
            if (parll) {
                targetDkLines.add("}&");
            }
            if (step++ % maxStep == 0) {
                if (parll) {
                    targetDkLines.add("wait");
                }
            }
        }
    }


    private String addSub(String target, String sub, boolean subFix) {
        if (subFix) {
            //String sub= DockerPlatformEnum.ADM64.getPlatform();
            if (!StringUtils.contains(target, ":")) {
                target = target + ":";
            } else {
                target = target + "_";
            }
            target = target + sub;
        }
        return target;
    }

    private void manifest(String target, String targetX86, String targetArm64, List<String> targetLines) {
        targetLines.add("docker  manifest create -a --insecure " + target + " " + targetX86 + "  " + targetArm64 + "");
        targetLines.add("docker  manifest annotate " + target + " " + targetX86 + "   --os-features linux/ADM64");
        targetLines.add("docker  manifest annotate " + target + " " + targetArm64 + "   --os-features linux/ARM64");
        targetLines.add("docker  manifest push -p --insecure " + target + "");
    }

}
