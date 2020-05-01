package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

@Getter
public enum DockerPlatformEnum {
    ARM64("aarch64"),
    ADM64("x86_64"),
    NO_SUFFIX("noSuffix",false);
    private String platform;
    private boolean suffix = true;

    DockerPlatformEnum(String platform) {
        this.platform = platform;
    }

    DockerPlatformEnum(String platform, boolean suffix) {
        this.platform = platform;
        this.suffix = suffix;
    }

    public static DockerPlatformEnum getPlatform(String platform) {
        for (DockerPlatformEnum value : DockerPlatformEnum.values()) {
            if (StringUtils.equals(value.platform, platform)) {
                return value;
            }
        }
        return null;
    }

    public static Set<DockerPlatformEnum> getPlatforms(String[] platforms) {
        return Arrays.stream(platforms).map(DockerPlatformEnum::getPlatform).collect(Collectors.toSet());
    }
}
