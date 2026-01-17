package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class RocketmqConsoleCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_rocketmq_console_pre";
        String post = "soft_rocketmq_console_next";
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("rocketmq_console", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/mirrors/RocketMQ-Externals.git rocketmq-externals"));
        list.add(new CmdModel("rocketmq_console", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-externals;git checkout rocketmq-console-1.0.0"));
        list.add(new CmdModel("rocketmq_console", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-externals/rocketmq-console;mvn versions:set -DnewVersion=release"));
        list.add(new CmdModel("rocketmq_console", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-externals/rocketmq-console;mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip"));
        list.add(new CmdModel("rocketmq_console", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/rocketmq-externals/rocketmq-console;cp target/rocketmq-console-ng-release.jar ${" + StrConstants.WS + "}/rocketmq-console-ng-release.jar"));
        {
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/rocketmq-console-ng-release.jar ${WS}/rocketmq-console-ng-release.jar"));
        }

        return list;
    }

}
