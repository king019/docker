package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum DockerPlatformEnum {
    ARM64("aarch64", true, "_","linux/arm64/v8"),
    ADM64("x86_64", true, "_","linux/amd64"),
    NO_SUFFIX("no_suffix", false, "_",""),
    ;
    private String platform;
    private String fromSplit;
    private String osArch;
    private boolean suffix = true;


    DockerPlatformEnum(String platform, boolean suffix, String fromSplit,String osArch) {
        this.platform = platform;
        this.suffix = suffix;
        this.fromSplit = fromSplit;
        this.osArch=osArch;
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
