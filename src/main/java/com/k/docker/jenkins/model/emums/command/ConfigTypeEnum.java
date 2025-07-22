package com.k.docker.jenkins.model.emums.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigTypeEnum {
    config_shell("config_shell"),
    config_config("config_config"),
    config_ssh("config_ssh"),
    config_all("config_all"),
    mkdir_all_file("dir_all"),
    ;


    private String code;


}
