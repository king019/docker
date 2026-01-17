package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class IotDbBackendCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_iot_db_backend_pre";
        String post = "soft_iot_db_backend_next";
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitcode.com/gh_mirrors/io/iotdb-web-workbench.git"));
        return list;
    }

}
