package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum DockerParamEnum {
    MIN_INDEX("minIndex", "-999"),
    ORIGIN("origin", "false"),
    NEXUS_ALPINE("nexusApline", "false"),
    WORK_SPACE("ws", "${WORKSPACE}"),
    //LOCAL_REGION("local", "false"),
    THREAD("thread", "1"),
    INCLUDE("in", ""),
    REPLACE("rep", "false"),
    PUSH("push", "true"),
    //IN_DOCKER("dk", "true"),
    EXCLUDE("ex", ""),
    RP_GIT("rpgit", "false"),
    RP_TXT("rptxt", "false"), SUF("suf", "true"),
    MIX("mix", "true"),
    RP_SETTING("rpset", "false");
    private String cmd;
    private String def;

    DockerParamEnum(String cmd, String def) {
        this.cmd = cmd;
        this.def = def;
    }

    public static DockerParamEnum getEnum(String param) {
        for (DockerParamEnum paramEnum : DockerParamEnum.values()) {
            if (StringUtils.equals(param, paramEnum.getCmd())) {
                return paramEnum;
            }
        }
        return null;
    }
}
