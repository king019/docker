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

public class JenkinsBuildShell {
    public static DockerConfigModel configModel = new DockerConfigModel();
    static int multi = 1;
    static int minIndex = -999;
    static int maxIndex = 9999999;
    static boolean replace = false;
    static boolean push = true;
    static boolean prune = false;
    static List<String> includes = Lists.newArrayList();
    static List<String> excludes = Lists.newArrayList();
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();

    public static void main(String[] args) throws Exception {
        if (ArrayUtils.isNotEmpty(args)) {
            String arg = args[0];
            String[] splits = StringUtils.split(arg, "@");
            for (String split : splits) {
                if (StringUtils.contains(split, "=")) {
                    String[] splitInner = split.split("=");
                    DockerParamEnum paramEnum = DockerParamEnum.getEnum(splitInner[0]);
                    if (Objects.nonNull(paramEnum)) {
                        map.put(paramEnum, splitInner[1]);
                    }
                }
            }
        }

        DockerJenkinsModel.setWORKSPACE(JenkinsUtil.getVal(DockerParamEnum.WORK_SPACE, map));
        {
            boolean origin = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.ORIGIN, map));
            //boolean nexusAlpine = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.NEXUS_ALPINE, map));
            configModel.setOrigin(origin);
            //configModel.setNexusAlpine(nexusAlpine);
        }
        {
//            boolean inDocker = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.IN_DOCKER, map));
//            configModel.setInDocker(inDocker);
        }
        {
            multi = Integer.parseInt(JenkinsUtil.getVal(DockerParamEnum.THREAD, map));
            configModel.setMulti(multi);
        }
        {
            replace = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.REPLACE, map));
            configModel.setReplaceDockerGit(replace);
        }
        {
            push = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.PUSH, map));
            configModel.setPush(push);
        }
        {
            minIndex = JenkinsUtil.getInt(DockerParamEnum.MIN_INDEX, map);
            configModel.setMinIndex(minIndex);
        }
        {
//            boolean localRegion = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.LOCAL_REGION, map));
//            configModel.setLocalRegion(localRegion);
        }
        {
            boolean replaceGit = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.RP_GIT, map));
            configModel.setReplaceGit(replaceGit);
        }
        {
            String transFrom = JenkinsUtil.getVal(DockerParamEnum.TRANS_FROM, map);
            configModel.setTransFrom(transFrom);
        }
        {
            boolean mix = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.MIX, map));
            configModel.setMix(mix);
        }
        {
            boolean replaceSetting = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.RP_SETTING, map));
            configModel.setReplaceSetting(replaceSetting);
        }
        {
            boolean replaceTxt = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.RP_TXT, map));
            configModel.setReplaceTxt(replaceTxt);
        }
        {
            boolean suf = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.SUF, map));
            configModel.setSuffix(suf);
        }
        {
            maxIndex = Integer.parseInt(JenkinsUtil.getVal(DockerParamEnum.MAX_INDEX, map));
            configModel.setMaxIndex(maxIndex);
        }
        {
            boolean prune = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.PRUNE, map));
            configModel.setPrune(prune);
        }
        {
            boolean dkCache = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.BUILD_CACHE, map));
            configModel.setUseCache(dkCache);
        }
        {
            String val = JenkinsUtil.getVal(DockerParamEnum.INCLUDE, map);
            if (StringUtils.isNotBlank(val)) {
                includes.addAll(Lists.newArrayList(val.split(",")));
            }
        }
        {
            String val = JenkinsUtil.getVal(DockerParamEnum.EXCLUDE, map);
            if (StringUtils.isNotBlank(val)) {
                excludes.addAll(Lists.newArrayList(val.split(",")));
            }
            excludes.add("king019/docker:build");
            excludes.add("king019/debian");
            excludes.add("king019/source");
            //excludes.add("centos");
            excludes.removeAll(includes);
        }
        configModel.setIncludes(includes);
        configModel.setExcludes(excludes);
        JenkinsUtil shell = new JenkinsUtil();

        shell.jenkinsWrite(configModel);
    }

    @Test
    public void testGitReplace() throws Exception {
        List<String> lines = Lists.newArrayList();
        for (GitRemoteEnum remote : GitRemoteEnum.values()) {
            lines.add("echo '" + remote.getDesc() + "'");
            lines.add("git ls-remote " + remote.getDesc());
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

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
