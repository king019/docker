package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class DockerMirrorMonitorCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("dockerMonitorMonitor_1", List.of("dockerMonitorMonitor"), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/Mcwlgzs/docker-mirror-monitor.git"));
        list.add(new CmdModel("dockerMonitorMonitor_2", List.of("dockerMonitorMonitor"), "cd ${" + StrConstants.WS_VER + "};mkdir -p docker-mirror-monitor/backend/cache"));
        list.add(new CmdModel("dockerMonitorMonitor_3", List.of("dockerMonitorMonitor"), "cd ${" + StrConstants.WS_VER + "};mkdir -p docker-mirror-monitor/backend/logs"));
        return list;

    }

}
