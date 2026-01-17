package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class JenkinsCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("jenkins", List.of("jenkins"), "ENV", "jenkins_version=2.516.2"));
        list.add(new CmdModel("jenkins", List.of("jenkins"), "cd ${" + StrConstants.WS_VER + "};wget https://mirrors.huaweicloud.com/jenkins/war-stable/${jenkins_version}/jenkins.war"));
        list.add(new CmdModel("jenkins", List.of("jenkins"), "cp ${" + StrConstants.WS_VER + "}/jenkins.war ${" + StrConstants.WS + "}/tomcat/webapps/ROOT.war"));
        return list;

    }

}
