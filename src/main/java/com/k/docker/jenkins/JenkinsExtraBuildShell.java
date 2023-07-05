package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.docker.jenkins.model.DockerConfigModel;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.DockerParamEnum;
import com.k.docker.jenkins.model.emums.GitRemoteEnum;
import com.k.docker.jenkins.util.JenkinsUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JenkinsExtraBuildShell {
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();
    static int multi = 1;
    static int minIndex = -999;
    static int maxIndex = 9999999;
    static boolean replace = false;
    static boolean push = true;
    static List<String> includes = Lists.newArrayList();
    static List<String> excludes = Lists.newArrayList();
    public static DockerConfigModel configModel = new DockerConfigModel();



    @Test
    public void testReplaceTrue() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
//        configModel.setLocalRegion(true);
//        configModel.setInDocker(true);
        configModel.setPush(push);
        configModel.setMulti(multi);
        configModel.setReplaceDockerGit(true);
        shell.jenkinsWrite(configModel);
    }

    @Test
    public void testReplaceFalse() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        DockerJenkinsModel.setWORKSPACE("/opt/soft/version/aliyun/docker");
//        configModel.setLocalRegion(false);
//        configModel.setInDocker(true);
        configModel.setPush(push);
        configModel.setMulti(multi);
        configModel.setReplaceDockerGit(false);
        shell.jenkinsWrite(configModel);
    }

    @Test
    public void testOriginTrue() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        DockerJenkinsModel.setWORKSPACE("/opt/soft/version/aliyun/docker");
        configModel.setOrigin(false);
//        configModel.setLocalRegion(false);
//        configModel.setInDocker(true);
        configModel.setReplaceSetting(true);
        configModel.setReplaceTxt(true);
        configModel.setMaxIndex(549);
        configModel.setSuffix(false);
        configModel.setPush(push);
        //configModel.setDirPath("/opt/soft/version/aliyun/docker/");
        configModel.setMulti(multi);
        configModel.setReplaceDockerGit(false);
        shell.jenkinsWrite(configModel);
    }

    @Test
    public void testLocal550() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        DockerJenkinsModel.setWORKSPACE("/opt/soft/version/aliyun/docker");
        configModel.setOrigin(false);
//        configModel.setLocalRegion(false);
        //configModel.setInDocker(true);
        configModel.setReplaceSetting(true);
        configModel.setReplaceTxt(true);
        configModel.setSuffix(false);
        configModel.setMinIndex(549);
        configModel.setPush(push);
        configModel.setMulti(multi);
        configModel.setReplaceDockerGit(false);
        configModel.setBuildPath("build/common-extra");
        configModel.setBuildOut( "extraDest/");
        shell.jenkinsWrite(configModel);
    }

    @Test
    public void testAllBaseLocal() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        DockerJenkinsModel.setWORKSPACE("/opt/soft/version/aliyun/docker");
        configModel.setOrigin(false);
//        configModel.setLocalRegion(false);
//        configModel.setInDocker(false);
        configModel.setReplaceSetting(true);
        configModel.setReplaceTxt(true);
        configModel.setSuffix(false);
        configModel.setMaxIndex(549);
        configModel.setPush(push);
        configModel.setMix(false);
        configModel.setMulti(multi);
        configModel.setReplaceDockerGit(false);
        shell.jenkinsWrite(configModel);
    }

    @Test
    public void testLocalService() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        DockerJenkinsModel.setWORKSPACE("/opt/soft/version/aliyun/docker");
        configModel.setOrigin(false);
//        configModel.setLocalRegion(true);
//        configModel.setInDocker(false);
        configModel.setReplaceSetting(true);
        configModel.setReplaceTxt(true);
        List<String> includes = List.of("king019/rocketmq:das");
        // configModel.setIncludes(includes);
        configModel.setUseCache(true);
        configModel.setSuffix(false);
        configModel.setPush(push);
        configModel.setMulti(multi);
        configModel.setReplaceDockerGit(false);
        configModel.setTransFrom("dk5000");
        shell.jenkinsWrite(configModel);
    }


}
