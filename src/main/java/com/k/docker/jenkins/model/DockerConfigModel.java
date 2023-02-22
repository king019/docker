package com.k.docker.jenkins.model;


import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class DockerConfigModel {
    private boolean replaceGit = false;
    private boolean replaceSetting = false;
    private boolean origin = true;
    private boolean nexusAlpine = false;
    private boolean inDocker = false;
    /**
     * 只剩下nosuffix  local
     */
    private boolean localRegion = false;
    private boolean replaceTxt = false;
    private int minIndex=Integer.MIN_VALUE;
    private int maxIndex=Integer.MAX_VALUE;private String dirPath="./";
    private List<String> includes = Lists.newArrayList();
    private List<String> excludes = Lists.newArrayList();
}
