package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class RocketmqCmd {
    public static List<CmdModel> buildCmd() {
        String rocketPre = "soft_rocketmq_pre";
        String rocketNext = "soft_rocketmq_next";
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("rocketmq", List.of("rocketPre"), "ENV", "rocketmq_version=rocketmq-all-5.4.0"));
        list.add(new CmdModel("rocketmq", List.of(rocketPre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/apache/rocketmq.git"));
        list.add(new CmdModel("rocketmq", List.of(rocketPre), "cd ${" + StrConstants.WS_VER + "}/rocketmq;git checkout ${rocketmq_version}"));
        list.add(new CmdModel("rocketmq", List.of(rocketPre), "cd ${" + StrConstants.WS_VER + "}/rocketmq;mvn versions:set -DnewVersion=release"));
        list.add(new CmdModel("rocketmq", List.of(rocketPre), "cd ${" + StrConstants.WS_VER + "}/rocketmq;mvn -Prelease-all -DskipTests clean install"));
        list.add(new CmdModel("rocketmq", List.of(rocketPre), "cd ${" + StrConstants.WS_VER + "}/rocketmq;cp ./distribution/target/rocketmq-release.zip ${" + StrConstants.WS + "}/rocketmq-release.zip"));
        {


            list.add(new CmdModel("rocketmq", List.of(rocketNext), "COPY", "--from=pre ${WS}/rocketmq-release.zip ${WS}/rocketmq-release.zip"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "cd ${" + StrConstants.WS + "};unzip rocketmq-release.zip"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "cd ${" + StrConstants.WS + "};mv rocketmq-release rocketmq"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "mkdir -p ${" + StrConstants.WS + "}/rocketmq/store"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "mkdir -p ${" + StrConstants.WS + "}/rocketmq/conf"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "cd ${" + StrConstants.WS + "}/rocketmq/conf;echo 'storePathRootDir =" + StrConstants.WS_VAL + "/rocketmq/store' >> broker.properties"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "cd ${" + StrConstants.WS + "}/rocketmq/conf;echo 'autoCreateTopicEnable=true' >> broker.properties"));
            list.add(new CmdModel("rocketmq", List.of(rocketNext), "chmod -R 777 ${" + StrConstants.WS + "}/rocketmq"));
        }
        return list;
    }

}
