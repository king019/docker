package com.k.docker.jenkins.model;


import lombok.Data;

@Data
public class DockerConfigModel {
    private boolean replaceGit = false;
    private boolean replaceSetting = false;
    private boolean origin = true;
    private boolean nexusAlpine = false;
    private boolean inDocker = false;
    private boolean localRegion = false;
    private int minIndex=-999;
}
