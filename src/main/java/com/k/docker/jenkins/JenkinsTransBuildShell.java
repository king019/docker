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

    public static void main(String[] args) throws Exception {
        JenkinsTransBuildShell shell = new JenkinsTransBuildShell();
        shell.test();
    }

    @Test
    public void test() throws Exception {
        String resource = FWPathUtil.getTargetClassesPath("build/github/pull/Dockerfile");
        String targetAliyunPath = FWPathUtil.getTargetPath("pull/aliyun_qingdao.sh");
        String targetDk5000Path = FWPathUtil.getTargetPath("pull/dk5000.sh");
        String targetDk5001Path = FWPathUtil.getTargetPath("pull/dk5001.sh");
        File srcFile = new File(resource);
        System.out.println(srcFile.getAbsolutePath());
        List<String> lines = FileUtils.readLines(srcFile, Charset.defaultCharset());
        List<String> targetAliyunLines = Lists.newArrayList();
        List<String> targetDk5000Lines = Lists.newArrayList();
        List<String> targetDk5001Lines = Lists.newArrayList();
        aliyun(lines, targetAliyunLines, targetReg);
        dkline(lines, targetDk5000Lines, docker5000);
        dkline(lines, targetDk5001Lines, docker5001);
        FileUtils.writeLines(new File(targetAliyunPath), targetAliyunLines);
        FileUtils.writeLines(new File(targetDk5000Path), targetDk5000Lines);
        FileUtils.writeLines(new File(targetDk5001Path), targetDk5001Lines);
    }

    private void aliyun(List<String> lines, List<String> targetAliyunLines, String targetReg) {
        //aliyun
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                break;
            }
            String srcLine = line;
            targetAliyunLines.add("#" + line);
            targetAliyunLines.add("docker pull " + line);
            for (String reg : regSet) {
                line = StringUtils.replace(line, reg + "/", "");
            }
            int nsIndex = StringUtils.indexOf(line, "/");
            if (nsIndex > 0) {
                line = StringUtils.replaceOnce(line, "/", "-");
            }
            targetAliyunLines.add("docker tag " + srcLine + " " + targetReg + "/" + line);
            targetAliyunLines.add("docker push " + targetReg + "/" + line);
        }
    }

    private void dkline(List<String> lines, List<String> targetDkLines, String dockerHost) {
        //dk
        for (String line : lines) {
            if (StringUtils.isBlank(line)) {
                continue;
            }
            if (StringUtils.startsWith(line, ignore)) {
                continue;
            }
            String srcLine = line;
            targetDkLines.add("#" + line);
            targetDkLines.add("docker pull " + line);
            for (String reg : regSet) {
                line = StringUtils.replace(line, reg + "/", "");
            }

            targetDkLines.add("docker tag " + srcLine + " " + dockerHost + "/dk-" + line);
            targetDkLines.add("docker push " + dockerHost + "/dk-" + line);
        }
    }
}
