package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum DockerRegionEnum {
    HANG_ZHOU("hangzhou", "registry.cn-hangzhou.aliyuncs.com"),
    BEI_JING("beijing", "registry.cn-beijing.aliyuncs.com"),
    DOCKER("docker", "");
    private String region;
    private String host;

    DockerRegionEnum(String region, String host) {
        this.region = region;
        this.host = host;
    }

    public static DockerRegionEnum getRegion(String region) {
        for (DockerRegionEnum value : DockerRegionEnum.values()) {
            if (StringUtils.equals(value.region, region)) {
                return value;
            }
        }
        return DockerRegionEnum.DOCKER;
    }
}
