package com.k.docker.jenkins.model.emums.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonPrefixEnum {
    multi_run_cmd("DKCONFIG multi_run_cmd", "RUN"),
    multi_config("DKCONFIG multi_config", ""),

    ;
    private String code;
    private String cmd;

}
