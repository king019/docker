package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class DockerInitCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("dockerInit_WORKDIR", List.of("dockerInit"), "WORKDIR", "${WS}"));
        return list;
    }

}
