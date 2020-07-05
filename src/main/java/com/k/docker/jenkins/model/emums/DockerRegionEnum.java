package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

@Getter
public enum DockerRegionEnum {
    //HANG_ZHOU("hangzhou", "registry.cn-hangzhou.aliyuncs.com"),
    SHANG_HAI("aliyun_shanghai", "registry.cn-shanghai.aliyuncs.com"),
    HUHEHAOTE("aliyun_huhehaote", "registry.cn-huhehaote.aliyuncs.com"),
    SHENZHEN("aliyun_shenzhen", "registry.cn-shenzhen.aliyuncs.com"),
    BEI_JING("aliyun_beijing", "registry.cn-beijing.aliyuncs.com"),
    DOCKER("docker", ""),
    //SMP("smp", "docker:5000"),
    LOCAL("local_region", "docker:5000", true);
    private String region;
    private String host;
    private boolean special;

    public static boolean filterSpecile(DockerRegionEnum region) {
        return region.special;
    }

    DockerRegionEnum(String region, String host) {
        this.region = region;
        this.host = host;
    }

    DockerRegionEnum(String region, String host, boolean special) {
        this.region = region;
        this.host = host;
        this.special = special;
    }

    public static DockerRegionEnum getRegion(String region) {
        for (DockerRegionEnum value : DockerRegionEnum.values()) {
            if (StringUtils.equals(value.region, region)) {
                return value;
            }
        }
        return null;
    }    public static Set<DockerRegionEnum> getRegions(Set<String> regions) {
        return  regions.stream().map(DockerRegionEnum::getRegion).collect(Collectors.toSet());
    }
}
