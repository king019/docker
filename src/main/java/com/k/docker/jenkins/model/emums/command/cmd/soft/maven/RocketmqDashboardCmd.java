package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class RocketmqDashboardCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_rocketmq_dashboard_pre";
        String post = "soft_rocketmq_dashboard_next";
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("rocketmq_dashboard", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/king019/rocketmq-dashboard.git"));
        list.add(new CmdModel("rocketmq_dashboard", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-dashboard;git checkout rocketmq-dashboard-1.0.0"));
        list.add(new CmdModel("rocketmq_dashboard", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-dashboard;mvn clean package -Dmaven.test.skip=true"));
        list.add(new CmdModel("rocketmq_dashboard", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-dashboard;cp target/rocketmq-dashboard-1.0.0.jar ${" + StrConstants.WS + "}/rocketmq-dashboard.jar"));
        {
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/rocketmq-dashboard.jar ${WS}/rocketmq-dashboard.jar"));
        }

        return list;
    }

}
