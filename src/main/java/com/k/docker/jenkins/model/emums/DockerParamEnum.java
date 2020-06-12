package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum DockerParamEnum {
    WORK_SPACE("ws","${WORKSPACE}"),
    THREAD("thread","1"),
    INCLUDE("in",""),
    REPLACE("rep","false"),
     EXCLUDE  ("ex","");
    private String cmd;
    private String def;

    DockerParamEnum(String cmd, String def) {
        this.cmd = cmd;
        this.def = def;
    }
    public static DockerParamEnum getEnum(String param){
        for (DockerParamEnum paramEnum : DockerParamEnum.values()) {
            if (StringUtils.equals(param,paramEnum.getCmd())) {
                return paramEnum;
            }
        }return null;
    }
}
