package com.k.docker.jenkins.model.emums;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum BuildItemEnum {
    REGION("region.txt"),
    VERSION("version.txt"),
    INDEX("index.txt", "10000"),
    IGNORE("ignore.txt"),
    IGNORE_REGION("ignore_region.txt"),
    PLATFORM("platform.txt");
    private String item;
    private String def;

    BuildItemEnum(String item) {
        this.item = item;
    }

    BuildItemEnum(String item, String def) {
        this.item = item;
        this.def = def;
    }

    public static Set<String> ITEMS = Arrays.stream(BuildItemEnum.values()).map(BuildItemEnum::getItem).collect(Collectors.toSet());
    public static Map<String, BuildItemEnum> MAP = Maps.uniqueIndex(Arrays.stream(BuildItemEnum.values()).iterator(), BuildItemEnum::getItem);

    public static BuildItemEnum getItem(String item) {
        return MAP.get(item);
    }
}
