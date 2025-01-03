package com.k.docker.jenkins.model;


import com.k.docker.jenkins.model.emums.DockerPlatformEnum;
import com.k.docker.jenkins.model.emums.DockerRegionEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class DockerPushModel {
    private Set<String> regSet = Set.of(
            "registry.cn-hangzhou.aliyuncs.com",
            "registry.cn-beijing.aliyuncs.com",
            "swr.cn-east-2.myhuaweicloud.com",
            "registry.gitlab.cn",
            "ghcr.io",
            "quay.io",
            "skywalking.docker.scarf.sh",
            "docker.elastic.co",
            "registry.k8s.io"
    );  private String specialName = null;
    private String pullImage;
    private String tagImage;
    private String pushImage;
    private DockerRegionEnum dockerRegionEnum;
    private boolean subFix = false;
    private DockerPlatformEnum platformEnum;
    private List<String> lines = new ArrayList<>();


    private void buildPull() {
        String sub = "";
        if (!platformEnum.equals(DockerPlatformEnum.NO_SUFFIX)) {
            sub = " --platform=" + platformEnum.getOsArch();
        }
        lines.add("docker pull " + pullImage + " " + sub);

    }

    private String addSub(String target, String sub, boolean subFix) {
        if (subFix) {
            //String sub= DockerPlatformEnum.ADM64.getPlatform();
            if (!StringUtils.contains(target, ":")) {
                target = target + ":";
            } else {
                target = target + "_";
            }
            target = target + sub;
        }
        return target;
    }
    private void buildPushImage(){
        String transSource=pullImage;

        for (String reg : regSet) {
            transSource = StringUtils.replace(transSource, reg + "/", "");
        }
        if (StringUtils.contains(transSource, "/")) {
            transSource = transSource.replace("/", "_");
        }
        if (StringUtils.isNotBlank(specialName)) {
            transSource = specialName;
        }
      String  dockerHost=dockerRegionEnum.getHost()+"/"+dockerRegionEnum.getNamespace();
        pushImage = dockerHost + "/" + transSource;
    }

    private void buildTag() {
          tagImage  = pushImage;
        if (subFix) {
            tagImage = addSub(pushImage, platformEnum.getPlatform(), subFix);
        }
        lines.add("docker tag " + pullImage + " " + tagImage);
    }

    private void buildManifest() {
        if (subFix) {
            String targetArm64 = addSub(pushImage, DockerPlatformEnum.ARM64.getPlatform(), subFix);
            String targetX86 = addSub(pushImage, DockerPlatformEnum.ADM64.getPlatform(), subFix);
            manifest(pushImage, targetX86, targetArm64);
        }
    }

    private void manifest(String target, String targetX86, String targetArm64) {
        lines.add("docker  manifest create -a --insecure " + target + " " + targetX86 + "  " + targetArm64);
        lines.add("docker  manifest annotate " + target + " " + targetX86 + "   --os-features " + DockerPlatformEnum.ADM64.getOsArch());
        lines.add("docker  manifest annotate " + target + " " + targetArm64 + "   --os-features " + DockerPlatformEnum.ARM64.getOsArch());
        lines.add("docker  manifest push -p --insecure " + target);
    }

    private void buildPush() {
        lines.add("docker push " + tagImage);
    }

    @Override
    public String toString() {
        buildPull();
        buildPushImage();
        buildTag();
        buildPush();
        buildManifest();
        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            sb.append("\n");
            sb.append(line);
        }
        return sb.toString();
    }

}
