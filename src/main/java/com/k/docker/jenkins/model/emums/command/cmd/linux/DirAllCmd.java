package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class DirAllCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("dir_all_ws", List.of("dir_all"), "mkdir -p ${" + StrConstants.WS + "}"));
        list.add(new CmdModel("dir_all_ws_ver", List.of("dir_all"), "mkdir -p ${" + StrConstants.WS_VER + "}"));
        list.add(new CmdModel("dir_all_ssh", List.of("dir_all"), "mkdir -p /root/.ssh"));
        list.add(new CmdModel("dir_all_repository", List.of("dir_all"), "mkdir -p /root/.m2/repository"));
        list.add(new CmdModel("dir_all_docker", List.of("dir_all"), "mkdir -p /etc/docker"));
        list.add(new CmdModel("dir_all_root_docker", List.of("dir_all"), "mkdir -p /root/.docker"));
        return list;
    }
}
