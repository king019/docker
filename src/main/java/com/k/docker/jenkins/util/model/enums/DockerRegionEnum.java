package com.k.docker.jenkins.util.model.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum DockerRegionEnum {
    HANG_ZHOU("hangzhou", "registry.cn-hangzhou.aliyuncs.com"),
    DOCKER("", "");
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
