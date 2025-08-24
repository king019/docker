package com.k.docker.jenkins.model.emums.command;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum CommonDirEnum {
    ssh("/root/.ssh"),
    repository("/root/.m2/repository"),
    version("/opt/soft/version"),
    tool("/opt/soft/tool"),
    docker("/etc/docker"),
    roo_docker("/root/.docker"),
    conf("/conf"),
    app("/app"),
    soft_conf("/opt/soft/conf"),
    soft_data("/opt/soft/data"),
    ;
    public static Map<String, CommonDirEnum> MAP = Maps.uniqueIndex(Arrays.stream(CommonDirEnum.values()).iterator(), CommonDirEnum::getCode);
    public static List<CommonDirEnum> LIST = Arrays.stream(CommonDirEnum.values()).toList();
    public static List<CommonDirEnum> ALL = LIST;
    public static Multimap<String, CommonDirEnum> MULTI_MAP = ArrayListMultimap.create();

    static {
        for (CommonDirEnum fileEnum : ALL) {
            MULTI_MAP.put(DkConfigTypeEnum.mkdir_all_file.getCode(), fileEnum);
        }
    }

    private String code;

    public static Collection<CommonDirEnum> getMultiItem(String item) {
        return MULTI_MAP.get(item);
    }
}
