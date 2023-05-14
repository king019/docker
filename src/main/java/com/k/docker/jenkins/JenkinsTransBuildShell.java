package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.k.dep.common.util.FWPathUtil;
import com.k.docker.jenkins.model.emums.DockerPlatformEnum;
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
            "registry.gitlab.cn",
            "ghcr.io"
    );
    private String targetReg = "registry.cn-qingdao.aliyuncs.com/king019";
    private String ignore = "@ignore";

    private String docker5000 = "docker:5000";
    private String docker5001 = "docker:5000";
    private int maxStep = 20;
    private int defStep = 1;
    private boolean arm = false;
    private boolean subFix = false;
    private boolean parll = true;
    private boolean manifest = true;

    public static void main(String[] args) throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.arm = true;
        shell.subFix = true;
        shell.test();
    }

    @Test
    public void test3() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 3;
        shell.parll = false;
        shell.test();
    }

    @Test
    public void testPar() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 3;
        shell.arm = true;
        shell.test();
    }

    @Test
    public void testNoMulti() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 3;
        shell.parll = false;
        shell.arm = true;
        shell.manifest = false;
        shell.test();
    }

    @Test
    public void testMulti() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 3;
        shell.parll = true;
        shell.arm = true;
        shell.manifest = true;
        shell.test();
    }

    //mvn test -Dtest=com.k.docker.jenkins.JenkinsTransBuildShell#testArm -DskipTests=true
    @Test
    public void testArm() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 1;
        shell.parll = false;
        shell.arm = true;
        shell.subFix = true;
        shell.test();
    }

    @Test
    public void testNoArm() throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.maxStep = 1;
        shell.parll = false;
        shell.arm = false;
        shell.manifest = false;
        shell.test();
    }


    @Test
    public void test() throws Exception {
        String resource = FWPathUtil.getTargetClassesPath("build/github/pull/Dockerfile");
        String targetAliyunPath = FWPathUtil.getTargetPath("pull/aliyun_qingdao.sh");
        String targetDk5000Path = FWPathUtil.getTargetPath("pull/dk5000.sh");
        //String targetDk5001Path = FWPathUtil.getTargetPath("pull/dk5001.sh");
        String targetDk5001AliyunPath = FWPathUtil.getTargetPath("pull/dk5001aliyun.sh");
        File srcFile = new File(resource);
        List<String> lines = FileUtils.readLines(srcFile, Charset.defaultCharset());
        lines = lines.stream().filter(s -> !StringUtils.startsWith(s, "#")).toList();
        List<String> targetAliyunLines = Lists.newArrayList();
        List<String> targetDk5000Lines = Lists.newArrayList();
        List<String> targetDk5001Lines = Lists.newArrayList();
        List<String> targetDk5001AliyunLines = Lists.newArrayList();
        aliyun(lines, targetAliyunLines, targetReg);
        dkline(lines, targetDk5000Lines, docker5000);
        //dkline(lines, targetDk5001Lines, docker5001);
        dkAliyunline(lines, targetDk5001AliyunLines, targetReg, docker5001);
        FileUtils.writeLines(new File(targetAliyunPath), targetAliyunLines);
        FileUtils.writeLines(new File(targetDk5000Path), targetDk5000Lines);
        //FileUtils.writeLines(new File(targetDk5001Path), targetDk5001Lines);
        FileUtils.writeLines(new File(targetDk5001AliyunPath), targetDk5001AliyunLines);
    }

//    private void aliyun(List<String> lines, List<String> targetAliyunLines, String targetReg) {
//        //aliyun
//        int step = defStep;
//        for (String line : lines) {
//            if (StringUtils.isBlank(line)) {
//                continue;
//            }
//            if (StringUtils.startsWith(line, ignore)) {
//                break;
//            }
//            if (parll) {
//                targetAliyunLines.add("{");
//            }
//
//            String source = line;
//            String transSource = line;
//            String target;
//            targetAliyunLines.add("#" + line);
//            targetAliyunLines.add("docker pull " + line);
//            for (String reg : regSet) {
//                transSource = StringUtils.replace(transSource, reg + "/", "");
//            }
//            int nsIndex = StringUtils.indexOf(transSource, "/");
//            if (nsIndex > 0) {
//                transSource = StringUtils.replaceOnce(transSource, "/", "-");
//            }
//            target = targetReg + "/" + transSource;
//            targetAliyunLines.add("docker tag " + source + " " + target);
//            targetAliyunLines.add("docker push " + target);
//            if (parll) {
//                targetAliyunLines.add("}&");
//            }
//            if (step++ % maxStep == 0) {
//                if (parll) {
//                    targetAliyunLines.add("wait");
//                }
//            }
//        }
//    }

    private void aliyun(List<String> lines, List<String> targetDkLines, String dockerHost) {
        //dk
        int step = defStep;
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                break;
            }


            if (parll) {
                targetDkLines.add("{");
            }

            String source = line;
            String transSource = line;
            for (String reg : regSet) {
                transSource = StringUtils.replace(transSource, reg + "/", "");
            }
            if (StringUtils.contains(transSource, "/")) {
                transSource = transSource.replace("/", "_");
            }
            String target;
            targetDkLines.add("echo '" + line + "'");
            targetDkLines.add("docker pull " + line);
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
    private void dkline(List<String> lines, List<String> targetDkLines, String dockerHost) {
        //dk
        int step = defStep;
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
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
            if (parll) {
                targetDkAliyunLines.add("{");
            }
            String source = line;
            String transSource = line;
            if (StringUtils.contains(transSource, "/")) {
                transSource = transSource.replace("/", "_");
            }
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
            target = dockerHost + "/" + source;
            targetDkAliyunLines.add("docker tag " + transSource + " " + target);
            targetDkAliyunLines.add("docker push " + target);
            if (parll) {
                targetDkAliyunLines.add("}&");
            }
            if (step++ % maxStep == 0) {
                if (parll) {
                    targetDkAliyunLines.add("wait");
                }
            }
        }
    }
}
