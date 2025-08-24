package com.k.docker.jenkins.model.emums.command;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

@Getter
@AllArgsConstructor
public enum DkConfigTypeEnum {
    mkdir_all_file("dir_all", CommonPrefixEnum.mkdir_file, 1),
    go_proxy("go_proxy", CommonPrefixEnum.sed_mirror, 2),
    //CommonFileEnum
    config_all("config_all", CommonPrefixEnum.multi_file, 3),
    docker("docker", CommonPrefixEnum.sed_mirror, 4),


    alpine("alpine", CommonPrefixEnum.sed_mirror),
    almalinux_9("almalinux_9", CommonPrefixEnum.sed_mirror),

    debian_11("debian_11", CommonPrefixEnum.sed_mirror),
    debian_12("debian_12", CommonPrefixEnum.sed_mirror),
    ubuntu_22("ubuntu_22", CommonPrefixEnum.sed_mirror),
    ubuntu_24("ubuntu_24", CommonPrefixEnum.sed_mirror),
    //待使用开始
    rockylinux_8("rockylinux_8", CommonPrefixEnum.sed_mirror),
    rockylinux_9("rockylinux_9", CommonPrefixEnum.sed_mirror),
    anolisos_8("anolisos_8", CommonPrefixEnum.sed_mirror),
//待使用结束

    server("server", CommonPrefixEnum.file),


    //DKCONFIG mkdir_file dir_all
    //DKCONFIG sed_mirror go_proxy
    //DKCONFIG multi_file config_all
    dk_config_all("dk_config_all", CommonPrefixEnum.multi_config),
    ;

    public static Multimap<String, DkConfigTypeEnum> MULTI_MAP = ArrayListMultimap.create();
    public static Map<String, DkConfigTypeEnum> MAP = Maps.newHashMap();

    static {
        MULTI_MAP.put(dk_config_all.getCode(), mkdir_all_file);
        MULTI_MAP.put(dk_config_all.getCode(), go_proxy);
        MULTI_MAP.put(dk_config_all.getCode(), config_all);
        MULTI_MAP.put(dk_config_all.getCode(), docker);
        for (DkConfigTypeEnum value : DkConfigTypeEnum.values()) {
            MAP.put(value.getCode(), value);
        }

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
