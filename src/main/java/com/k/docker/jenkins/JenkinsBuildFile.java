package com.k.docker.jenkins;

import com.google.common.collect.Sets;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.util.JenkinsUtil;
import com.k.docker.jenkins.util.PathUtil;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JenkinsBuildFile {

    public static void main(String[] args) throws Exception {
        JenkinsBuildFile shell = new JenkinsBuildFile();
        shell.test();
    }

    @Test
    public void test() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        List<DockerJenkinsModel> models = shell.buildModel();
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
        String downPath = PathUtil.getTargetPath("down.txt");
        FileUtils.writeLines(new File(downPath), lines);
    }
}
