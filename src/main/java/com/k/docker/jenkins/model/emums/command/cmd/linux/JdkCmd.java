package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class JdkCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("jdk", List.of("rhel_jdk", "rhel_jdk8"), "dnf -y install  maven"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk8"), "dnf -y install  java-1.8.0-openjdk-devel"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk8"), "echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk8"), "echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk8"), "rm -fr /etc/alternatives/java"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk8"), "ln -s /usr/lib/jvm/java-1.8.0-openjdk/bin/java /etc/alternatives/java"));


        list.add(new CmdModel("jdk", List.of("rhel_jdk"), "dnf -y install  java-21-openjdk-devel"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk"), "echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk"), "echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk"), "rm -fr /etc/alternatives/java"));
        list.add(new CmdModel("jdk", List.of("rhel_jdk"), "ln -s /usr/lib/jvm/java-21-openjdk/bin/java /etc/alternatives/java"));

        list.add(new CmdModel("jdk", List.of("alphne_jdk", "alphne_jdk8"), "apk add maven"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk8"), "apk add openjdk8"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk8"), "echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk8"), "echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk8"), "rm -fr /usr/lib/jvm/default-jvm"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk8"), "ln -s /usr/lib/jvm/java-1.8-openjdk /usr/lib/jvm/default-jvm"));


        list.add(new CmdModel("jdk", List.of("alphne_jdk"), "apk add openjdk21"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk"), "echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk"), "echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk"), "rm -fr /usr/lib/jvm/default-jvm"));
        list.add(new CmdModel("jdk", List.of("alphne_jdk"), "ln -s /usr/lib/jvm/java-21-openjdk /usr/lib/jvm/default-jvm"));

//        list.add(new CmdModel("jdk", List.of("rhel_jdk", "rhel_jdk8", "alphne_jdk", "alphne_jdk8"), "source /etc/profile"));
//        list.add(new CmdModel("jdk", List.of("rhel_jdk", "rhel_jdk8", "alphne_jdk", "alphne_jdk8"), "mvn -v"));

        return list;


    }

}
