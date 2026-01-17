package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class ServerCmd {
    public static List<CmdModel> buildCmd() {
        String server8Pre = "server8_pre";
        String server8Next = "server8_next";
        String server11Pre = "server11_pre";
        String server11Next = "server11_next";
        String server17Pre = "server17_pre";
        String server17Next = "server17_next";
        String serverPre = "server_pre";
        String serverNext = "server_next";
        List<CmdModel> list = new ArrayList<>();

//          https://central.sonatype.com/artifact/org.apache.tomcat/tomcat
        //https://tomcat.apache.org/whichversion.html
        list.add(new CmdModel("tomcat9", List.of(server8Pre), "ENV", "tomcat_version=9.0.113"));
        list.add(new CmdModel("tomcat10", List.of(server11Pre), "ENV", "tomcat_version=10.1.50"));
        list.add(new CmdModel("tomcat11", List.of(server17Pre, serverPre), "ENV", "tomcat_version=11.0.15"));
        /////////         https://central.sonatype.com/artifact/org.eclipse.jetty/jetty-home
        //                https://jetty.org/download.html
        list.add(new CmdModel("jetty9", List.of(server8Pre), "ENV", "jetty_version=9.4.58.v20250814"));
        list.add(new CmdModel("jetty11", List.of(server11Pre), "ENV", "jetty_version=11.0.26"));
        list.add(new CmdModel("jetty12", List.of(server17Pre, serverPre), "ENV", "jetty_version=12.1.5"));
        ///////////
        list.add(new CmdModel("tomcat_1", List.of(server8Pre, server11Pre, server17Pre, serverPre), "mvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz -Dtransitive=false"));
        list.add(new CmdModel("tomcat_2", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz ${" + StrConstants.WS + "}"));
        list.add(new CmdModel("tomcat_3", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cd ${" + StrConstants.WS + "};tar -xzf tomcat-${tomcat_version}.tar.gz"));
        list.add(new CmdModel("tomcat_4", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cd ${" + StrConstants.WS + "};mv apache-tomcat-${tomcat_version} tomcat"));
        list.add(new CmdModel("tomcat_5", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cd ${" + StrConstants.WS + "}/tomcat/webapps;rm -fr *"));
        list.add(new CmdModel("tomcat_6", List.of(server8Pre, server11Pre, server17Pre, serverPre), "mkdir -p ${" + StrConstants.WS + "}/tomcat/webapps"));

        list.add(new CmdModel("tomcat_6", List.of(server8Next, server11Next, server17Next, serverNext), "COPY", "--from=pre ${WS}/tomcat ${WS}/tomcat"));


        list.add(new CmdModel("jetty_1", List.of(server8Pre, server11Pre, server17Pre, serverPre), "mvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-home -Dversion=${jetty_version} -Dpackaging=tar.gz -Dtransitive=false"));
        list.add(new CmdModel("jetty_2", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cp /root/.m2/repository/org/eclipse/jetty/jetty-home/${jetty_version}/jetty-home-${jetty_version}.tar.gz ${" + StrConstants.WS + "}"));
        list.add(new CmdModel("jetty_3", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cd ${" + StrConstants.WS + "};tar -xzf jetty-home-${jetty_version}.tar.gz"));
        list.add(new CmdModel("jetty_4", List.of(server8Pre, server11Pre, server17Pre, serverPre), "cd ${" + StrConstants.WS + "};mv jetty-home-${jetty_version} jetty"));
//        list.add(new CmdModel(serverPre, List.of(server8Pre, server11Pre, server17Pre, serverPre), "rm -fr /root/.m2/repository"));
        list.add(new CmdModel("tomcat_6", List.of(server8Next, server11Next, server17Next, serverNext), "COPY", "--from=pre ${WS}/jetty ${WS}/jetty"));
        return list;
    }

}
