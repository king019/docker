package com.k.docker.jenkins.model.emums;

import lombok.Getter;

@Getter
public enum DockerBuildPathEnum {
    dockerDest("dockerDest/"),
    platform("platform/"),
    ;

    private String path;


    DockerBuildPathEnum(String path) {
        this.path = path;
    }

}
