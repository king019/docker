package com.k.docker.jenkins.model.emums.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigTypeEnum {
    config_shell("config_shell"),
    config_shell_group("multi_run_file"),
    config_config("config_config"),
    config_ssh("config_ssh"),

    ;


    private String code;

}
