package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum DockerRegionEnum {
    HANG_ZHOU("hangzhou", "registry.cn-hangzhou.aliyuncs.com"),
    BEI_JING("beijing", "registry.cn-beijing.aliyuncs.com"),
    DOCKER("docker", ""),
    LOCAL("local", "docker:5000",true);
    private String region;
    private String host;
    private boolean specile;

    public static boolean  filterSpecile(String region){
      return   getRegion(region).specile;
    }
    DockerRegionEnum(String region, String host) {
        this.region = region;
        this.host = host;
    }    DockerRegionEnum(String region, String host,boolean specile) {
        this.region = region;
        this.host = host; this.specile = specile;
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
