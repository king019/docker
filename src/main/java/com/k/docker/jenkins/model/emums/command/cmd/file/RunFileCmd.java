package com.k.docker.jenkins.model.emums.command.cmd.file;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class RunFileCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        //jdk8
        list.add(CmdModel.runFile("tomcat9", "server8", "shell/server/tomcat.sh", "tomcat.sh", "/tomcat.sh", "9.0.99", true));
        //jdk11
        list.add(CmdModel.runFile("tomcat10", "server11", "shell/server/tomcat.sh", "tomcat.sh", "/tomcat.sh", "10.1.48", true));
        //jdk17
        list.add(CmdModel.runFile("tomcat11", "server17", "shell/server/tomcat.sh", "tomcat.sh", "/tomcat.sh", "11.0.13", true));
        list.add(CmdModel.runFile("tomcat", "server", "shell/server/tomcat.sh", "tomcat.sh", "/tomcat.sh", "11.0.13", true));
        //jdk8
        list.add(CmdModel.runFile("jetty9", "server8", "shell/server/jetty.sh", "jetty.sh", "/jetty.sh", "9.4.58.v20250814", true));
        //jdk11
        list.add(CmdModel.runFile("jetty11", "server11", "shell/server/jetty.sh", "jetty.sh", "/jetty.sh", "11.0.26", true));
        //jdk17
        list.add(CmdModel.runFile("jetty12", "server17", "shell/server/jetty.sh", "jetty.sh", "/jetty.sh", "12.1.3", true));
        list.add(CmdModel.runFile("jetty", "server", "shell/server/jetty.sh", "jetty.sh", "/jetty.sh", "12.1.3", true));
        return list;
    }
}
