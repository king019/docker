package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class NacosCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_nacos_pre";
        String post = "soft_nacos_next";
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("nacos", List.of(pre, post), "ENV", "nacos_version=3.1.1"));
        list.add(new CmdModel("nacos", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/mirrors/Nacos.git nacos"));
        list.add(new CmdModel("nacos", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd nacos;git checkout ${nacos_version}"));
        list.add(new CmdModel("nacos", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd nacos;cd console;sed -i 's/<artifactId>spring-boot-maven-plugin<\\/artifactId>/<artifactId>spring-boot-maven-plugin<\\/artifactId><version>2.6.3<\\/version>/' pom.xml"));
        list.add(new CmdModel("nacos", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd nacos;mvn -Prelease-nacos -Dmaven.test.skip=true clean install"));
        list.add(new CmdModel("nacos", List.of(pre), "cd ${" + StrConstants.WS_VER + "};cd nacos;find . -name nacos-server-${nacos_version}.zip | awk -v nacos_version=${nacos_version}  '{print \"cp \" $1  \" " + StrConstants.WS_VAL + "/nacos-server-\"nacos_version\".zip\"}' | sh"));
        {
            list.add(new CmdModel("nacos", List.of(post), "COPY", "--from=pre ${WS}/nacos-server-${nacos_version}.zip ${WS}/nacos-server-${nacos_version}.zip"));
            list.add(new CmdModel("nacos", List.of(post), "cd ${" + StrConstants.WS + "};unzip nacos-server-${nacos_version}.zip"));
            list.add(new CmdModel("nacos", List.of(post), "cat /application.properties > ${" + StrConstants.WS + "}/nacos/conf/application.properties"));
        }
        return list;
    }

}
