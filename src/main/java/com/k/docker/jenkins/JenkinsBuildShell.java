package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.DockerParamEnum;
import com.k.docker.jenkins.util.JenkinsUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JenkinsBuildShell {
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();
    static int multi = 1;
    static boolean replace = false;
    static boolean push = true;
    static List<String> includes = Lists.newArrayList();
    static List<String> excludes = Lists.newArrayList();
    static boolean inDocker = false;

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
            multi = Integer.parseInt(JenkinsUtil.getVal(DockerParamEnum.THREAD, map));
        }
        {
            replace = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.REPLACE, map));
        }
        {
            inDocker = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.IN_DOCKER, map));
        }
        {
            push = StringUtils.equals("true", JenkinsUtil.getVal(DockerParamEnum.PUSH, map));
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
            excludes.add("ubuntu");
            excludes.add("centos");
            excludes.add("jenkins");
            excludes.removeAll(includes);
        }
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, replace, push, inDocker);
    }

    @Test
    public void testReplaceTrue() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, true, push);
    }

    @Test
    public void testReplaceFalse() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes, false, push);
    }
}
