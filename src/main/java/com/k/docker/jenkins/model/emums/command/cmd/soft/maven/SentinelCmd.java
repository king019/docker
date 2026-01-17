package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class SentinelCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_sentinel_pre";
        String post = "soft_sentinel_next";
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("sentinel", List.of(pre, post), "ENV", "sentinel_version=1.8.9"));
        list.add(new CmdModel("sentinel", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/mirrors/Sentinel.git sentinel"));
        list.add(new CmdModel("sentinel", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/sentinel/sentinel-dashboard;git checkout 1.8.9"));
        list.add(new CmdModel("sentinel", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/sentinel/sentinel-dashboard;mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip"));
        list.add(new CmdModel("sentinel", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/sentinel/sentinel-dashboard;find . -name sentinel-dashboard.jar | awk '{print \"cp \" $1  \" " + StrConstants.WS_VAL + "/sentinel-dashboard.jar\"}' | sh"));
        {
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/sentinel-dashboard.jar ${WS}/sentinel-dashboard.jar"));

        }
        return list;
    }

}
