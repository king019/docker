package com.k.docker.jenkins;

import com.k.docker.jenkins.util.JenkinsUtilFrom;
import org.junit.Test;

public class JenkinsBuildShellFrom {

    @Test
    public void build() throws Exception {
        String buildFrom = "/opt/soft/version/aliyun/docker/src/main/resources/build/from/";
        String build = "/opt/soft/version/aliyun/docker/src/main/resources/build/to/";
        trans(buildFrom, build);
    }

    @Test
    public void self() throws Exception {
        String buildFrom = "/opt/soft/version/aliyun/docker/src/main/resources/self/from/";
        String build = "/opt/soft/version/aliyun/docker/src/main/resources/self/to/";
        trans(buildFrom, build);
    }

    private void trans(String from, String to) throws Exception {
        JenkinsUtilFrom shell = new JenkinsUtilFrom();
        shell.jenkinsWrite(from, to);
    }

}
