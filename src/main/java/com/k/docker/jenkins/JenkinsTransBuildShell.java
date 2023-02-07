package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.k.dep.common.util.FWPathUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

public class JenkinsTransBuildShell {
    private Set<String> regSet = Set.of(
            "registry.cn-hangzhou.aliyuncs.com",
            "registry.cn-beijing.aliyuncs.com",
            "swr.cn-east-2.myhuaweicloud.com",
            "registry.gitlab.cn");
    private String targetReg = "registry.cn-qingdao.aliyuncs.com/king019";
    private String ignore = "@ignore";

    private String docker5000 = "docker:5000";
    private String docker5001 = "docker:5001";
    private int maxStep = 20;
    private int defStep = 1;

    public static void main(String[] args) throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.test();
    }

    @Test
    public void test3() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 3;
        shell.test();
    }

    @Test
    public void test() throws Exception {
        String resource = FWPathUtil.getTargetClassesPath("build/github/pull/Dockerfile");
        String targetAliyunPath = FWPathUtil.getTargetPath("pull/aliyun_qingdao.sh");
        String targetDk5000Path = FWPathUtil.getTargetPath("pull/dk5000.sh");
        String targetDk5001Path = FWPathUtil.getTargetPath("pull/dk5001.sh");
        String targetDk5001AliyunPath = FWPathUtil.getTargetPath("pull/dk5001aliyun.sh");
        File srcFile = new File(resource);
        List<String> lines = FileUtils.readLines(srcFile, Charset.defaultCharset());
        List<String> targetAliyunLines = Lists.newArrayList();
        List<String> targetDk5000Lines = Lists.newArrayList();
        List<String> targetDk5001Lines = Lists.newArrayList();
        List<String> targetDk5001AliyunLines = Lists.newArrayList();
        aliyun(lines, targetAliyunLines, targetReg);
        dkline(lines, targetDk5000Lines, docker5000);
        dkline(lines, targetDk5001Lines, docker5001);
        dkAliyunline(lines, targetDk5001AliyunLines, targetReg, docker5001);
        FileUtils.writeLines(new File(targetAliyunPath), targetAliyunLines);
        FileUtils.writeLines(new File(targetDk5000Path), targetDk5000Lines);
        FileUtils.writeLines(new File(targetDk5001Path), targetDk5001Lines);
        FileUtils.writeLines(new File(targetDk5001AliyunPath), targetDk5001AliyunLines);
    }

    private void aliyun(List<String> lines, List<String> targetAliyunLines, String targetReg) {
        //aliyun
        int step = defStep;
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                break;
            }
            targetAliyunLines.add("{");
            String source = line;
            String transSource = line;
            String target;
            targetAliyunLines.add("#" + line);
            targetAliyunLines.add("docker pull " + line);
            for (String reg : regSet) {
                transSource = StringUtils.replace(transSource, reg + "/", "");
            }
            int nsIndex = StringUtils.indexOf(transSource, "/");
            if (nsIndex > 0) {
                transSource = StringUtils.replaceOnce(transSource, "/", "-");
            }
            target = targetReg + "/" + transSource;
            targetAliyunLines.add("docker tag " + source + " " + target);
            targetAliyunLines.add("docker push " + target);
            targetAliyunLines.add("}&");
            if (step++ % maxStep == 0) {
                targetAliyunLines.add("wait");
            }
        }
    }

    private void dkline(List<String> lines, List<String> targetDkLines, String dockerHost) {
        //dk
        int step = defStep;
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                continue;
            }
            targetDkLines.add("{");
            String source = line;
            String transSource = line;
            String target;
            targetDkLines.add("#" + line);
            targetDkLines.add("docker pull " + line);
            for (String reg : regSet) {
                transSource = StringUtils.replace(transSource, reg + "/", "");
            }
            target = dockerHost + "/dk-" + transSource;
            targetDkLines.add("docker tag " + source + " " + target);
            targetDkLines.add("docker push " + target);
            targetDkLines.add("}&");
            if (step++ % maxStep == 0) {
                targetDkLines.add("wait");
            }
        }
    }

    private void dkAliyunline(List<String> lines, List<String> targetDkAliyunLines, String targetReg, String dockerHost) {
        //dk
        int step = defStep;
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                continue;
            }
            targetDkAliyunLines.add("{");
            String source = line;
            String transSource = line;
            String target;
            targetDkAliyunLines.add("#" + line);
            String sourceDk;
            {
                for (String reg : regSet) {
                    transSource = StringUtils.replace(transSource, reg + "/", "");
                }
                int nsIndex = StringUtils.indexOf(transSource, "/");
                if (nsIndex > 0) {
                    transSource = StringUtils.replaceOnce(transSource, "/", "-");
                }
                transSource = targetReg + "/" + transSource;
                targetDkAliyunLines.add("docker pull " + transSource);
            }
            for (String reg : regSet) {
                source = StringUtils.replace(source, reg + "/", "");
            }
            target = dockerHost + "/dk-" + source;
            targetDkAliyunLines.add("docker tag " + transSource + " " + target);
            targetDkAliyunLines.add("docker push " + target);
            targetDkAliyunLines.add("}&");
            if (step++ % maxStep == 0) {
                targetDkAliyunLines.add("wait");
            }
        }
    }
}
