package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class DockerCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("docker_1", List.of("docker"), "mkdir -p /root/.docker;cp /config.json /root/.docker/config.json"));
        list.add(new CmdModel("docker_2", List.of("docker"), "mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json"));
        return list;
    }

}
