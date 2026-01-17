package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class LinuxEnvCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("baseEnv_WS", List.of("baseEnv"), "ENV", "WS=" + StrConstants.WS_VAL));
        list.add(new CmdModel("baseEnv_TZ", List.of("baseEnv"), "ENV", "TZ=" + StrConstants.TZ_VAL));
        list.add(new CmdModel("baseEnv_WS_VER", List.of("baseEnv"), "ENV", "WS_VER=" + StrConstants.WS_VER_VAL));
        return list;
    }

}
