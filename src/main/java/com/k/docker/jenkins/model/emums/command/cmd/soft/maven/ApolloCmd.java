package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class ApolloCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_apollo_pre";
        String post = "soft_apollo_next";
        String admin = "soft_apollo_admin";
        String config = "soft_apollo_config";
        String portal = "soft_apollo_portal";
        List<CmdModel> list = new ArrayList<>();

        {

            list.add(new CmdModel("apollo_1", List.of(pre, post), "ENV", "apollo_version=v2.4.0"));
            list.add(new CmdModel("apollo_5", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/mirrors/apollo.git"));
            list.add(new CmdModel("apollo_6", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd apollo;git checkout ${apollo_version}"));
            list.add(new CmdModel("apollo_7", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd apollo;mvn versions:set -DnewVersion=release"));
            list.add(new CmdModel("apollo_8", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd apollo;cd scripts;sh ./build.sh"));
            list.add(new CmdModel("apollo_9", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd apollo;cp ./apollo-adminservice/target/apollo-adminservice-release-github.zip ${" + StrConstants.WS + "}/apollo-adminservice-release-github.zip"));
            list.add(new CmdModel("apollo_10", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd apollo;cp ./apollo-configservice/target/apollo-configservice-release-github.zip ${" + StrConstants.WS + "}/apollo-configservice-release-github.zip"));
            list.add(new CmdModel("apollo_11", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd apollo;cp ./apollo-portal/target/apollo-portal-release-github.zip ${" + StrConstants.WS + "}/apollo-portal-release-github.zip"));

        }
        {
            list.add(new CmdModel("apollo_12", List.of(post), "mkdir -p " + StrConstants.WS + "/apollo-admin"));
            list.add(new CmdModel("apollo_12", List.of(post), "mkdir -p " + StrConstants.WS + "/apollo-config"));
            list.add(new CmdModel("apollo_12", List.of(post), "mkdir -p " + StrConstants.WS + "/apollo-portal"));
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/apollo-adminservice-release-github.zip ${WS}/apollo-admin/apollo-adminservice-release-github.zip"));
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/apollo-configservice-release-github.zip ${WS}/apollo-config/apollo-configservice-release-github.zip"));
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/apollo-portal-release-github.zip ${WS}/apollo-portal/apollo-portal-release-github.zip"));

        }


        {

            list.add(new CmdModel("apollo_12", List.of(admin), "cd ${" + StrConstants.WS + "}/apollo-admin;unzip apollo-adminservice-release-github.zip"));

        }
        {
            list.add(new CmdModel("apollo_12", List.of(config), "cd ${" + StrConstants.WS + "}/apollo-config;unzip apollo-configservice-release-github.zip"));
        }
        {
            list.add(new CmdModel("apollo_12", List.of(portal), "cd ${" + StrConstants.WS + "}/apollo-portal;unzip apollo-portal-release-github.zip"));
        }

        return list;
    }

}
