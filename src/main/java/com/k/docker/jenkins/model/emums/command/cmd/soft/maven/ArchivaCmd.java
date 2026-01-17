package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class ArchivaCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_archiva_pre";
        String post = "soft_archiva_next";
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("archiva_1", List.of(pre, post), "ENV", "archiva_version=2.2.10"));
        list.add(new CmdModel("archiva_2", List.of(pre), "mvn dependency:get -Dtransitive=false -DgroupId=org.apache.archiva -DartifactId=archiva-jetty -Dversion=${archiva_version} -Dclassifier=bin -Dpackaging=tar.gz"));
        list.add(new CmdModel("archiva_3", List.of(pre), "cp /root/.m2/repository/org/apache/archiva/archiva-jetty/${archiva_version}/archiva-jetty-${archiva_version}-bin.tar.gz ${" + StrConstants.WS + "}"));

        {
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/archiva-jetty-${archiva_version}-bin.tar.gz ${WS}/archiva-jetty-${archiva_version}-bin.tar.gz"));
            list.add(new CmdModel("archiva_4", List.of(post), "cd ${" + StrConstants.WS + "};tar -xzf archiva-jetty-${archiva_version}-bin.tar.gz"));
            list.add(new CmdModel("archiva_5", List.of(post), "cd ${" + StrConstants.WS + "};mv apache-archiva-${archiva_version} archiva"));
        }


        return list;
    }

}
