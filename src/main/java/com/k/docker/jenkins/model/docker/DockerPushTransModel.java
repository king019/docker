package com.k.docker.jenkins.model.docker;


import com.k.docker.jenkins.model.emums.docker.DockerRegionEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DockerPushTransModel {

    private DockerPushModel srcModel;
    private DockerPushModel descModel;
    private List<String> lines = new ArrayList<>();

    public static DockerPushTransModel init(String line, boolean arm, boolean subFix, DockerRegionEnum srcRegion, DockerRegionEnum destRegion) {
        DockerPushTransModel transModel = new DockerPushTransModel();
        DockerPushModel srcModelInner = DockerPushModel.init(line, arm, subFix, srcRegion);
        DockerPushModel descModelInner = DockerPushModel.init(line, arm, subFix, destRegion);
        transModel.setSrcModel(srcModelInner);
        transModel.setDescModel(descModelInner);
        srcModelInner.toString();
        descModelInner.toString();
        return transModel;
    }


    private void buildPull() {
        lines.add("docker pull " + srcModel.getPushImage());

    }


    private void buildTag() {
        lines.add("docker tag " + srcModel.getPushImage() + " " + descModel.getPushImage());
    }


    private void buildPush() {
        lines.add("docker push " + descModel.getPushImage());
    }

    @Override
    public String toString() {
        buildPull();
        buildTag();
        buildPush();
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append("\n");
            sb.append(line);
        }
        return sb.toString();
    }

}
