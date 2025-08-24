package com.k.docker.jenkins.model.emums.trans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FromTransEnum {
    DOCKER("docker", ""),
    DK5000("dk5000", "docker:5000/"),
    ;
    private String name;
    private String registry;

    public static String getReg(String to) {
        for (FromTransEnum value : FromTransEnum.values()) {
            if (value.getName().equals(to)) {
                return value.getRegistry();
            }
        }
        return "";
    }
}
