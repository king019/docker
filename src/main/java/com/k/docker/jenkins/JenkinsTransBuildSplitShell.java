package com.k.docker.jenkins;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.k.dep.common.util.FWPathUtil;
import com.k.docker.jenkins.consts.DockerConstans;
import com.k.docker.jenkins.model.docker.DockerPushModel;
import com.k.docker.jenkins.model.docker.DockerPushTransModel;
import com.k.docker.jenkins.model.emums.docker.DockerParamEnum;
import com.k.docker.jenkins.model.emums.docker.DockerRegionEnum;
import com.k.docker.jenkins.util.JenkinsUtil;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
public class JenkinsTransBuildSplitShell {
    private static Map<DockerParamEnum, String> map = Maps.newHashMap();
    private String ignore = "@ignore";
    private String remark = "#";
    private int maxStep = 20;
    private int defStep = 1;
    private boolean arm = false;
    //添加后缀
    private boolean subFix = false;
    //并发执行
    private boolean parll = true;
    //添加多系统执行
    private boolean manifest = true;
    private String end = "endTag";

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
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.maxStep = NumberUtils.toInt(JenkinsUtil.getVal(DockerParamEnum.MAX_STEP, map));
        shell.parll = true;
        shell.arm = BooleanUtils.toBoolean(JenkinsUtil.getVal(DockerParamEnum.ARM, map));
        shell.manifest = true;
        shell.subFix = true;
        shell.test();
    }

    private static boolean arch() {
        boolean arm = false;
        String osArch = System.getProperty("os.arch");
        System.out.println("系统架构原始值是:" + osArch);
        if ("arm".equalsIgnoreCase(osArch) || "aarch64".equalsIgnoreCase(osArch)) {
            System.out.println("系统架构是ARM");
            arm = true;
        } else if (Set.of("x86", "amd64", "x86_64").contains(osArch)) {
            System.out.println("系统架构是X86");
            arm = false;
        } else {
            System.out.println("未知的系统架构: " + osArch);
        }
        return arm;
    }

    //mvn test -Dtest=com.k.docker.jenkins.JenkinsTransBuildShell#testArm -DskipTests=true
    @Test
    public void testArm() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.setMaxStep(3);
        shell.setParll(true);
        shell.setArm(true);
        shell.setManifest(true);
        shell.setSubFix(true);
        shell.test();
    }

    @Test
    public void testX86() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.setMaxStep(3);
        shell.setParll(false);
        shell.setArm(false);
        shell.setManifest(true);
        shell.setSubFix(true);
        shell.test();
    }

    @Test
    public void testX86Parll() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.maxStep = 1;
        shell.parll = true;
        shell.arm = false;
        shell.manifest = true;
        shell.subFix = true;
        shell.test();
    }

    //@Test
    public void test3() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.maxStep = 3;
        shell.parll = false;
        shell.test();
    }

    //@Test
    public void testPar() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.maxStep = 3;
        shell.arm = true;
        shell.test();
    }

    //@Test
    public void testNoMulti() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.maxStep = 3;
        shell.parll = false;
        shell.arm = true;
        shell.manifest = false;
        shell.test();
    }

    //@Test
    public void testMulti() throws Exception {
        JenkinsTransBuildSplitShell shell = new JenkinsTransBuildSplitShell();
        shell.maxStep = 3;
        shell.parll = true;
        shell.arm = true;
        shell.manifest = true;
        shell.test();
    }


    //@Test
    public void test() throws Exception {
        String resource = FWPathUtil.getTargetClassesPath("unbuild/common-other/github/pull/Dockerfile");
        File srcFile = new File(resource);
        List<String> lines = FileUtils.readLines(srcFile, Charset.defaultCharset());
        ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
        String pre = "base";
        String preFix = "@";
        for (String line : lines) {
            if (StringUtils.contains(line, ignore)) {
                break;
            }
            if (StringUtils.contains(line, remark)) {
                continue;
            }

            if (StringUtils.contains(line, preFix)) {
                pre = line.replaceAll(preFix, "").trim();
            } else {
                multimap.put(pre, line);
            }
        }
        for (String key : multimap.keySet()) {
            List<String> nowLines = multimap.get(key);
            nowLines.add(end);
            test(nowLines, key);
        }
        List<String> shellLines = new ArrayList<>();
        String shellFile = FWPathUtil.getTargetPath("aliyun_qingdao.sh");
        for (String key : multimap.keySet()) {
            shellLines.add("bash ./target/pull/" + key + "/aliyun_qingdao.sh;");
        }
        FileUtils.writeLines(new File(shellFile), shellLines);
    }

    //@Test
    public void test(Collection<String> lines, String pre) throws Exception {
        String resource = FWPathUtil.getTargetClassesPath("build/github/pull/Dockerfile");
        String targetAliyunPath = FWPathUtil.getTargetPath("pull/" + pre + "/aliyun_qingdao.sh");
        String targetDk5000Path = FWPathUtil.getTargetPath("pull/" + pre + "/dk5000.sh");
        //String targetDk5001Path = FWPathUtil.getTargetPath("pull/dk5001.sh");
        String targetDk5000AliyunPath = FWPathUtil.getTargetPath("pull/" + pre + "/dk5000aliyun.sh");
        String targetDk5001AliyunPath = FWPathUtil.getTargetPath("pull/" + pre + "/dk5001aliyun.sh");
        File srcFile = new File(resource);
        //List<String> lines = FileUtils.readLines(srcFile, Charset.defaultCharset());
        //lines = lines.stream().filter(s -> !StringUtils.startsWith(s, "#")).collect(Collectors.toList());
        List<String> targetAliyunLines = Lists.newArrayList("#!/bin/bash", "\n", "set -x");
        List<String> targetDk5000Lines = Lists.newArrayList();
        List<String> targetDk5000AliyunLines = Lists.newArrayList();
        List<String> targetDk5001AliyunLines = Lists.newArrayList();
        aliyun(lines, targetAliyunLines, DockerRegionEnum.QING_DAO);
        aliyun(lines, targetDk5000Lines, DockerRegionEnum.DK5000);
        //aliyun(lines, targetDk5001AliyunLines, docker5001);


        // dkline(lines, targetDk5000Lines, docker5000);
        //dkline(lines, targetDk5001Lines, docker5001);
        dkAliyunline(lines, targetDk5000AliyunLines, DockerRegionEnum.QING_DAO, DockerRegionEnum.DK5000);
        dkAliyunline(lines, targetDk5001AliyunLines, DockerRegionEnum.QING_DAO, DockerRegionEnum.DOCKER_5001);
        FileUtils.writeLines(new File(targetAliyunPath), targetAliyunLines);
        FileUtils.writeLines(new File(targetDk5000Path), targetDk5000Lines);
        FileUtils.writeLines(new File(targetDk5000AliyunPath), targetDk5000AliyunLines);
        FileUtils.writeLines(new File(targetDk5001AliyunPath), targetDk5001AliyunLines);
    }

    private void aliyun(Collection<String> lines, List<String> targetDkLines, DockerRegionEnum dockerRegionEnum) {
        //dk
        int step = defStep;
        boolean endTag = false;
        for (String line : lines) {
            endTag = StringUtils.equals(line, end);
            if (!endTag) {
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                if (StringUtils.startsWith(line, ignore)) {
                    break;
                }
                if (parll) {
                    targetDkLines.add("{");
                }
                DockerPushModel model = DockerPushModel.init(line, arm, subFix, dockerRegionEnum);
                targetDkLines.add("\n");
                targetDkLines.add("echo '" + line + "'");
                targetDkLines.add(model.toString());
                if (parll) {
                    targetDkLines.add("}&");
                }
                if (step++ % maxStep == 0) {
                    if (parll) {
                        targetDkLines.add("wait");
                        targetDkLines.addAll(DockerConstans.prunes);
//                        targetDkLines.add("docker image prune -a -f");
                    }
                }
            } else {
                targetDkLines.add("wait");
                targetDkLines.addAll(DockerConstans.prunes);
//                targetDkLines.add("docker image prune -a -f");
            }
        }
    }


    private void dkAliyunline(Collection<String> lines, List<String> targetLines, DockerRegionEnum srcRegion, DockerRegionEnum destRegion) {
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
                targetLines.add("{");
            }
            DockerPushTransModel transModel = DockerPushTransModel.init(line, arm, subFix, srcRegion, destRegion);
            targetLines.add(transModel.toString());
            if (parll) {
                targetLines.add("}&");
            }
            if (step++ % maxStep == 0) {
                if (parll) {
                    targetLines.add("wait");
                    targetLines.addAll(DockerConstans.prunes);
//                    targetLines.add("docker image prune -a -f");
                }
            }
        }
    }

}
