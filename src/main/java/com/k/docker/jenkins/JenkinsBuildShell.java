package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.docker.jenkins.model.DockerConfigModel;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.ConstantEnum;
import com.k.docker.jenkins.model.emums.DockerParamEnum;
import com.k.docker.jenkins.model.emums.GitRemoteEnum;
import com.k.docker.jenkins.util.JenkinsUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//mvn clean compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/opt/soft/version/aliyun/docker@thread=1@rep=true@push=false@local=true"
public class JenkinsBuildShell {
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();
    static int multi = 1;
    static boolean replace = false;
    static boolean push = true;
    static List<String> includes = Lists.newArrayList();
    static List<String> excludes = Lists.newArrayList();
    static boolean inDocker = false;
    static boolean localRegion = false;
    static boolean replaceGit = false;
    static boolean replaceSetting = false;
    static boolean origin = true;
    static DockerConfigModel configModel = new DockerConfigModel();

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
            origin = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.ORIGIN, map));
            configModel.setOrigin(origin);
        }
        {
            inDocker = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.IN_DOCKER, map));
        }
        {
            multi = Integer.parseInt(JenkinsUtil.getVal(DockerParamEnum.THREAD, map));
        }
        {
            replace = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.REPLACE, map));
        }

        {
            push = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.PUSH, map));
        }
        {
            localRegion = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.LOCAL_REGION, map));
        }
        {
            replaceGit = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.RP_GIT, map));
        }
        {
            replaceSetting = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.RP_SETTING, map));
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
            excludes.add("king019/source");
            //excludes.add("centos");
            excludes.removeAll(includes);
        }
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, replace, push, inDocker, localRegion, replaceGit, replaceSetting, configModel);
    }

    @Test
    public void testReplaceTrue() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, true, push, true, true, configModel);
    }

    @Test
    public void testReplaceFalse() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, false, push, true, true, configModel);
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
}
