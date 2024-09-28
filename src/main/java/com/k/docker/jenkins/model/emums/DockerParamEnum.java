package com.k.docker.jenkins.model.emums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum DockerParamEnum {
    TRANS_FROM("tsfrom", ""),
    MIN_INDEX("minIndex", "-999"),
    MAX_INDEX("maxIndex", "999999999"),
    ORIGIN("origin", "false"),
    //NEXUS_ALPINE("nexusApline", "false"),
    WORK_SPACE("ws", "${WORKSPACE}"),
    //LOCAL_REGION("local", "false"),
    THREAD("thread", "1"),
    INCLUDE("in", ""),
    //替换docker中的git地址
    REPLACE("rep", "false"),
    PUSH("push", "false"),
    //IN_DOCKER("dk", "true"),
    EXCLUDE("ex", ""),
    //替换本地git
    RP_GIT("rpgit", "false"),
    //执行replace.txt
    RP_TXT("rptxt", "false"),
    //添加x86、arm信息
    SUF("suf", "false"),
    //生成manifest的x86、arm信息
    MIX("mix", "false"),
    PRUNE("prune", "false"),
    RP_SETTING("rpset", "false"),
    BUILD_Path("buildpath", "build/common"),
    BUILD_CACHE("dkcache", "true");
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
