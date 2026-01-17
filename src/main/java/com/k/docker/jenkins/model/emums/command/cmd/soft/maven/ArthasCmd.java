package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class ArthasCmd {
    public static List<CmdModel> buildCmd() {
        String rocketPre = "soft_arthas_pre";
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("arthas_1", List.of(rocketPre), "ENV", "arthas_version=4.1.4"));
        list.add(new CmdModel("arthas_2", List.of(rocketPre), "mvn dependency:get -Dtransitive=false -DgroupId=com.taobao.arthas -DartifactId=arthas-packaging -Dversion=${arthas_version} -Dclassifier=bin -Dpackaging=zip"));
        list.add(new CmdModel("arthas_3", List.of(rocketPre), "cp /root/.m2/repository/com/taobao/arthas/arthas-packaging/${arthas_version}/arthas-packaging-${arthas_version}-bin.zip ${" + StrConstants.WS + "}"));
        list.add(new CmdModel("arthas_4", List.of(rocketPre), "cd ${" + StrConstants.WS + "};unzip arthas-packaging-${arthas_version}-bin.zip"));
        return list;
    }

}
