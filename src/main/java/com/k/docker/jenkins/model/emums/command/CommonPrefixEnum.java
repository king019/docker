package com.k.docker.jenkins.model.emums.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonPrefixEnum {
    mkdir_file("DKCONFIG mkdir_file", "RUN"),
    multi_file("DKCONFIG multi_file", "COPY"),
    sed_mirror("DKCONFIG sed_mirror", "RUN"),
    file("DKCONFIG file", "COPY"),
    multi_config("DKCONFIG multi_config", ""),

    ;
    private String code;
    private String cmd;

}
