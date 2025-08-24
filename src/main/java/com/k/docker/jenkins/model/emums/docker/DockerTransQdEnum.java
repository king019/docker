package com.k.docker.jenkins.model.emums.docker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum DockerTransQdEnum {
    hangzhou("registry.cn-hangzhou.aliyuncs.com"),
    beijing("registry.cn-beijing.aliyuncs.com"),
    myhuaweicloud("swr.cn-east-2.myhuaweicloud.com"),
    gitlab("registry.gitlab.cn"),
    ghcr("ghcr.io"),
    quay("quay.io"),
    skywalking("skywalking.docker.scarf.sh"),
    elastic("docker.elastic.co"),
    k8s("registry.k8s.io"),
    ecr("public.ecr.aws"),
    jianmuhub("docker.jianmuhub.com"),
    ;

    private String host;

    public static Set<String> queryHosts() {
        return Arrays.stream(DockerTransQdEnum.values()).map(dockerTransQdEnum -> dockerTransQdEnum.host).collect(Collectors.toSet());
    }
}
