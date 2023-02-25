package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum DockerPlatformEnum {
    ARM64("aarch64", true, "_"),
    ADM64("x86_64", true, "_"),
    NO_SUFFIX("no_suffix", false, "_");
    private String platform;
    private String fromSplit;
    private boolean suffix = true;


    DockerPlatformEnum(String platform, boolean suffix, String fromSplit) {
        this.platform = platform;
        this.suffix = suffix;
        this.fromSplit = fromSplit;
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
