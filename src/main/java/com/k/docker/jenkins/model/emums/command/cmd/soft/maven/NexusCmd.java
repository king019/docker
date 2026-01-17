package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

import static com.k.docker.jenkins.model.emums.constant.StrConstants.WS_VAL;

public class NexusCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_nexus_pre";
        String post = "soft_nexus_next";
        List<CmdModel> list = new ArrayList<>();

        //3.41.1-01  ok
        //
        //3.72.0-04   jdk8
        //3.86.2-01   jdk17
        //3.87.0-03   jdk21
        list.add(new CmdModel("nexus_latest", List.of(pre, post), "ENV", "nexus_version=3.41.1-01"));
        list.add(new CmdModel("nexus_latest", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/mirrors/nexus-public.git"));
        list.add(new CmdModel("nexus_latest", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/nexus-public;git checkout release-${nexus_version}"));
        list.add(new CmdModel("nexus_latest", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/nexus-public;sed -i 's/<\\/yarnVersion>/<\\/yarnVersion><nodeDownloadRoot>https:\\/\\/mirrors.huaweicloud.com\\/nodejs\\/<\\/nodeDownloadRoot><npmDownloadRoot>https:\\/\\/mirrors.huaweicloud.com\\/npm\\/<\\/npmDownloadRoot><yarnDownloadRoot>https:\\/\\/mirrors.huaweicloud.com\\/yarn\\/<\\/yarnDownloadRoot><npmRegistryURL>https:\\/\\/registry.npmmirror.com<\\/npmRegistryURL><yarnConfig><registry>https:\\/\\/registry.npmmirror.com<\\/registry><\\/yarnConfig>/g' ./pom.xml"));
        list.add(new CmdModel("nexus_latest", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/nexus-public;sed -i 's/install --immutable/install/g' ./pom.xml"));
        list.add(new CmdModel("nexus_latest", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/nexus-public;mvn clean install -DskipTests -Dmaven.javadoc.skip=true"));
        list.add(new CmdModel("nexus_latest", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/nexus-public;find . -name nexus-base-template-${nexus_version}.zip | awk -v nexus_version=${nexus_version}  '{print \"cp \" $1  \" " + WS_VAL + "/nexus-base-template-\"nexus_version\".zip\"}' | sh"));
        {
            list.add(new CmdModel("apollo_8", List.of(post), "COPY", "--from=pre ${WS}/nexus-base-template-${nexus_version}.zip ${WS}/nexus-base-template-${nexus_version}.zip"));
            list.add(new CmdModel("nexus_latest", List.of(post), "cd ${" + StrConstants.WS + "};unzip nexus-base-template-${nexus_version}.zip"));
            list.add(new CmdModel("nexus_latest", List.of(post), "cd ${" + StrConstants.WS + "};mv nexus-base-template-${nexus_version} nexus"));
        }
        return list;
    }

}
