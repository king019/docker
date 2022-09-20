package com.k.docker.jenkins.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.util.JenkinsUtil;
import com.k.docker.jenkins.util.PathUtil;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.k.docker.jenkins.JenkinsBuildShell.configModel;

public class JenkinsBuildFile {

    public static void main(String[] args) throws Exception {
        JenkinsBuildFile shell = new JenkinsBuildFile();
        shell.testADD();
    }

    @Test
    public void testADD() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        List<DockerJenkinsModel> models = shell.buildModel(configModel);
        Set<String> lines = Sets.newHashSet();
        for (DockerJenkinsModel model : models) {
            ListUtils.emptyIfNull(model.getDockerLines()).stream().filter(line -> line.startsWith("ADD")).forEach(lines::add);
        }
        lines = lines.stream().map(line -> {
            line = line.trim();
            int start = line.indexOf("http");
            int end = line.lastIndexOf(" ");
            return line.substring(start, end).trim();
        }).collect(Collectors.toSet());
        List<String> linesSort = Lists.newArrayList(lines);
        Collections.sort(linesSort);
        String downPath = PathUtil.getTargetPath("down.txt");
        FileUtils.writeLines(new File(downPath), linesSort);
    }

    @Test
    public void testGitClone() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        List<DockerJenkinsModel> models = shell.buildModel(configModel);
        Set<String> lines = Sets.newHashSet();
        for (DockerJenkinsModel model : models) {
            ListUtils.emptyIfNull(model.getDockerLines()).stream().filter(new Predicate<String>() {
                @Override
                public boolean test(String line) {
                    return line.contains("git clone");
                }
            }).forEach(lines::add);
        }
        lines = lines.stream().map(line -> {
            line = line.trim();
            int start = line.indexOf("git clone");
            int end = line.lastIndexOf(".git") + 4;
            return line.substring(start, end).trim();
        }).collect(Collectors.toSet());
        String downPath = PathUtil.getTargetPath("gitclone.txt");
        FileUtils.writeLines(new File(downPath), lines);
    }
}
