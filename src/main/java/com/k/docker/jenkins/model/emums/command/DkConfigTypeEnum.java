package com.k.docker.jenkins.model.emums.command;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

//DKCONFIG multi_config
@Getter
@AllArgsConstructor
public enum DkConfigTypeEnum {
    baseEnv("baseEnv", CommonPrefixEnum.multi_run_cmd, 10),
    dockerInit("dockerInit", CommonPrefixEnum.multi_run_cmd, 30),
    mkdir_all_file("dir_all", CommonPrefixEnum.multi_run_cmd, 100),
    config_all("config_all", CommonPrefixEnum.multi_run_cmd, 400),
    docker("docker", CommonPrefixEnum.multi_run_cmd, 500),
    settings("settings", CommonPrefixEnum.multi_run_cmd, 600),
    go_proxy("go_proxy", CommonPrefixEnum.multi_run_cmd, 700),
    linux_init("linux_init", CommonPrefixEnum.multi_run_cmd, 900),


    dk_config_all("dk_config_all", CommonPrefixEnum.multi_config),
    ;

    public static ListMultimap<String, DkConfigTypeEnum> MULTI_MAP = ArrayListMultimap.create();
    public static Map<String, DkConfigTypeEnum> MAP = Maps.newHashMap();

    static {
        MULTI_MAP.put(dk_config_all.getCode(), mkdir_all_file);
        MULTI_MAP.put(dk_config_all.getCode(), go_proxy);
        MULTI_MAP.put(dk_config_all.getCode(), config_all);
        MULTI_MAP.put(dk_config_all.getCode(), docker);
        MULTI_MAP.put(dk_config_all.getCode(), settings);
        MULTI_MAP.put(dk_config_all.getCode(), baseEnv);
        MULTI_MAP.put(dk_config_all.getCode(), linux_init);
        MULTI_MAP.put(dk_config_all.getCode(), dockerInit);
    }


    private String code;
    private CommonPrefixEnum prefixEnum;
    private int index = 0;

    DkConfigTypeEnum(String code, CommonPrefixEnum prefixEnum) {
        this.code = code;
        this.prefixEnum = prefixEnum;
    }


    public static List<DkConfigTypeEnum> getMultiItem(String code) {
        List<DkConfigTypeEnum> list = new ArrayList<>();
        Collection<DkConfigTypeEnum> enums = MULTI_MAP.get(code);
        if (CollectionUtils.isEmpty(enums)) {
            DkConfigTypeEnum configTypeEnum = MAP.get(code);
            if (Objects.nonNull(configTypeEnum)) {
                list.add(configTypeEnum);
            }
        } else {
            enums = enums.stream().sorted((o1, o2) -> o2.index - o1.index).toList();
            list.addAll(enums);
        }
        return list;
    }
}
