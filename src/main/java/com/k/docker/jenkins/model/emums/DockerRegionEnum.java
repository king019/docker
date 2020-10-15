package com.k.docker.jenkins.model.emums;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

@Getter
public enum DockerRegionEnum {
    //HANG_ZHOU("hangzhou", "registry.cn-hangzhou.aliyuncs.com"),
//    SHANG_HAI("aliyun_shanghai", "registry.cn-shanghai.aliyuncs.com", "sh"),
//    HUHEHAOTE("aliyun_huhehaote", "registry.cn-huhehaote.aliyuncs.com", "hhht"),
//    SHENZHEN("aliyun_shenzhen", "registry.cn-shenzhen.aliyuncs.com", "sz"),
    BEI_JING("aliyun_beijing", "registry.cn-beijing.aliyuncs.com", "bj"),
    DOCKER("docker", "", "dk"),
    //SMP("smp", "docker:5000"),
    LOCAL("local_region", "docker:5000", "lc", true);
    private String region;
    private String host;
    private boolean special;
    private String shortRegion;


    DockerRegionEnum(String region, String host, String shortRegion) {
        this.region = region;
        this.host = host;
        this.shortRegion = shortRegion;
    }

    DockerRegionEnum(String region, String host, String shortRegion, boolean special) {
        this.region = region;
        this.host = host;
        this.shortRegion = shortRegion;
        this.special = special;
    }

    public static boolean filterSpecile(DockerRegionEnum region) {
        return region.special;
    }

    public static DockerRegionEnum getRegion(String region) {
        for (DockerRegionEnum value : DockerRegionEnum.values()) {
            if (StringUtils.equals(value.region, region)) {
                return value;
            }
        }
        return null;
    }

    public static DockerRegionEnum getShortRegion(String shortRegion) {
        for (DockerRegionEnum value : DockerRegionEnum.values()) {
            if (StringUtils.equals(value.shortRegion, shortRegion)) {
                return value;
            }
        }
        return null;
    }

    public static Set<DockerRegionEnum> getRegions(Set<String> regions) {
        return regions.stream().map(DockerRegionEnum::getRegion).collect(Collectors.toSet());
    }

    public static List<DockerRegionEnum> getAllRegionEnums() {
        return Arrays.stream(DockerRegionEnum.values()).collect(Collectors.toList());
    }

    public static List<DockerRegionEnum> getRegionEnums(String shortRegions) {
        List<DockerRegionEnum> regions = Lists.newArrayList();
        for (String shortRegion : shortRegions.split(",")) {
            DockerRegionEnum region = getShortRegion(shortRegion);
            Optional.ofNullable(region).ifPresent(regions::add);
        }
        return regions;
    }

    public static String getAllRegion() {
        Set<String> regions = Arrays.stream(DockerRegionEnum.values()).map(DockerRegionEnum::getShortRegion).collect(Collectors.toSet());
        return StringUtils.join(regions, ",");
    }
}
