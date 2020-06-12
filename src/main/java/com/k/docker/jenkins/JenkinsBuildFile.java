package com.k.docker.jenkins;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.k.docker.jenkins.model.DockerJenkinsModel;
import com.k.docker.jenkins.model.emums.DockerParamEnum;
import com.k.docker.jenkins.util.JenkinsUtil;
import com.k.docker.jenkins.util.PathUtil;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.swing.plaf.ListUI;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JenkinsBuildFile {
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();
    static int multi = 1;
    static List<String> includes = Lists.newArrayList();
    static List<String> excludes = Lists.newArrayList();

    public static void main(String[] args) throws Exception {
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
        DockerJenkinsModel.setWORKSPACE(JenkinsUtil.getVal(DockerParamEnum.WORK_SPACE, map));
        {
            multi = Integer.parseInt(JenkinsUtil.getVal(DockerParamEnum.THREAD, map));
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
        }
        JenkinsUtil shell = new JenkinsUtil();
        shell.jenkinsWrite(multi, includes, excludes);
    }

    @Test
    public void test() throws Exception {
        JenkinsUtil shell = new JenkinsUtil();
        List<DockerJenkinsModel> models=   shell.buildModel();
        Set<String> lines= Sets.newHashSet();
        for (DockerJenkinsModel model : models) {
            ListUtils.emptyIfNull(model.getDockerLines()).stream().filter(line -> line.startsWith("ADD")).forEach(lines::add);
        }
        lines=  lines.stream().map(line -> {
            line=line.trim();
            int start = line.indexOf("http");
            int end = line.lastIndexOf(" ");
            return line.substring(start,end).trim();
        }).collect(Collectors.toSet());
        String downPath = PathUtil.getTargetPath("down.txt");
        FileUtils.writeLines(new File(downPath),lines);
    }
}
