package com.k.docker.jenkins.model.emums.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum OptTransEnum {
    ETC_PROFILE("addPre", "RUN", "source /etc/profile;chmod 755 /*.sh;"),
    APK_ADD("replace", "RUN", "apk add", "apk add --allow-untrusted "),
    ;
    private String type;
    private String cmd;
    private String plusCmd;
    private String plusExtCmd;


    OptTransEnum(String type, String cmd, String plusCmd) {
        this.type = type;
        this.cmd = cmd;
        this.plusCmd = plusCmd;
    }

    public static List<OptTransEnum> getList() {
        return Arrays.stream(OptTransEnum.values()).toList();
    }
}
