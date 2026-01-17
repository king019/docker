package com.k.docker.jenkins.model.emums.command.cmd.soft.mix;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class GiteaRunnerDockerCmd {
    public static List<CmdModel> buildCmd() {
        String alpine = "alpine_gitea_runner";
        String ubuntu = "ubuntu_gitea_runner";
        String rhel = "rhel_gitea_runner";
        List<CmdModel> list = new ArrayList<>();

        {
            list.add(new CmdModel(alpine, List.of(alpine), "apk add nodejs"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add openjdk21"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add maven"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add git"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add go"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add curl"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add docker"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add openssh-client"));
            list.add(new CmdModel(alpine, List.of(alpine), "apk add tar"));
        }
        {
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install nodejs"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install openjdk-21-jdk"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install maven"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install git"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install golang"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install curl"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install ca-certificates curl gnupg lsb-release"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "curl -fsSL https://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | gpg --dearmor -o /usr/share/keyrings/aliyun-docker-archive-keyring.gpg"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "echo 'deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/aliyun-docker-archive-keyring.gpg] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable' | tee /etc/apt/sources.list.d/docker.list > /dev/null"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get update"));
            list.add(new CmdModel(ubuntu, List.of(ubuntu), "apt-get -y install docker-ce"));
        }
        {
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install nodejs"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install java-21-openjdk-devel"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install maven"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install git"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install go"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install curl"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install yum-utils"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install device-mapper-persistent-data"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install lvm2"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo"));
            list.add(new CmdModel(rhel, List.of(rhel), "dnf -y install docker-ce"));
        }
        return list;
    }

}
