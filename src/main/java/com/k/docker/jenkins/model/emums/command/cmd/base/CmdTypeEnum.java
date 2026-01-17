package com.k.docker.jenkins.model.emums.command.cmd.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CmdTypeEnum {
    run_shell("run_shell", true),
    run_file("run_file", true),
    config_file("config_file", true),
    mirror("mirror", false),
    ;
    private String code;
    private boolean fromTo;
}
