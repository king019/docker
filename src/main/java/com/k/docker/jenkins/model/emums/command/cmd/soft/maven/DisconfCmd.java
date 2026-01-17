package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class DisconfCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_disconf_pre";
        String post = "soft_disconf_next";
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("disconf", List.of(pre), "mkdir -p ${WS}/conf"));
        list.add(new CmdModel("disconf", List.of(pre), "mkdir -p ${WS}/war"));
        list.add(new CmdModel("disconf", List.of(pre, post), "ENV", "disconf_version=2.6.36"));
        list.add(new CmdModel("disconf", List.of(pre, post), "ENV", "ONLINE_CONFIG_PATH=${WS}/conf"));
        list.add(new CmdModel("disconf", List.of(pre, post), "ENV", "WAR_ROOT_PATH=${WS}/war"));
        list.add(new CmdModel("disconf", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/mirrors/disconf.git"));
        list.add(new CmdModel("disconf", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/disconf;git checkout ${disconf_version}"));
//        list.add(new CmdModel("jenkins", List.of(pre), "export ONLINE_CONFIG_PATH=${WS}/conf"));
//        list.add(new CmdModel("jenkins", List.of(pre), "export WAR_ROOT_PATH=${WS}/war"));
//        list.add(new CmdModel("jenkins", List.of(pre), "export ONLINE_CONFIG_PATH"));
//        list.add(new CmdModel("jenkins", List.of(pre), "export WAR_ROOT_PATH"));
        list.add(new CmdModel("disconf", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/disconf/disconf-web;sh deploy/deploy.sh"));
        list.add(new CmdModel("disconf", List.of(pre), "cd ${" + StrConstants.WS + "}/tomcat/conf;sed -i 's/<\\/Host>/<Context path=\"\" docBase=\"\\" + StrConstants.WS_VAL + "\\/war\"\\/><\\/Host>/' server.xml"));

        return list;

    }

}
