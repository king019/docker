package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class ZookeeperUiCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_zookeeper_ui_pre";
        String post = "soft_zookeeper_ui_next";
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/king019/zkui.git"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/zkui;mvn versions:set -DnewVersion=release"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/zkui;sed -i 's/<artifactId>maven-assembly-plugin<\\/artifactId>/<artifactId>maven-assembly-plugin<\\/artifactId><version>3.3.0<\\/version>/g' pom.xml"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/zkui;mvn install -DskipTests -Dmaven.javadoc.skip=true"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/zkui;find . -name zkui-release-jar-with-dependencies.jar | awk -v WS=${WS} '{print \"cp \" $1 \" \" WS\"/zkui-release-jar-with-dependencies.jar\"}' | sh"));
        {
            list.add(new CmdModel("jenkins", List.of(post), "COPY", "--from=pre ${WS}/zkui-release-jar-with-dependencies.jar ${WS}/zkui-release-jar-with-dependencies.jar"));
        }
        return list;

    }

}
