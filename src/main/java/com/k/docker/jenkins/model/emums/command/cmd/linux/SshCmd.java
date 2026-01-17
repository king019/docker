package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class SshCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();


        list.add(new CmdModel("openssh_server", List.of("alpine_ssh"), "apk add openssh-server"));
        list.add(new CmdModel("openssh", List.of("alpine_ssh"), "apk add openssh"));
        list.add(new CmdModel("tzdata", List.of("alpine_ssh"), "apk add tzdata"));
        list.add(new CmdModel("openssh-client", List.of("alpine_ssh"), "apk add openssh-client"));
        list.add(new CmdModel("openssh_server", List.of("rhel_ssh"), "dnf -y install  openssh-server"));
        list.add(new CmdModel("openssh", List.of("rhel_ssh"), "dnf -y install  openssh"));
        list.add(new CmdModel("tzdata", List.of("rhel_ssh"), "dnf -y install  tzdata"));
        list.add(new CmdModel("openssh-client", List.of("rhel_ssh"), "dnf -y install  openssh-clients"));
        list.add(new CmdModel("localtime", List.of("alpine_ssh", "rhel_ssh"), "cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime"));
        list.add(new CmdModel("PermitRootLogin", List.of("alpine_ssh", "rhel_ssh"), "sed -i \"s/#PermitRootLogin.*/PermitRootLogin yes/g\" /etc/ssh/sshd_config"));
        list.add(new CmdModel("ssh_host_rsa_key", List.of("alpine_ssh", "rhel_ssh"), "ssh-keygen -t rsa -P \"\" -f /etc/ssh/ssh_host_rsa_key"));
        list.add(new CmdModel("ssh_host_ecdsa_key", List.of("alpine_ssh", "rhel_ssh"), "ssh-keygen -t ecdsa -P \"\" -f /etc/ssh/ssh_host_ecdsa_key"));
        list.add(new CmdModel("ssh_host_ed25519_key", List.of("alpine_ssh", "rhel_ssh"), "ssh-keygen -t ed25519 -P \"\" -f /etc/ssh/ssh_host_ed25519_key"));
        list.add(new CmdModel("id_dsa", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_dsa > /root/.ssh/id_dsa"));
        list.add(new CmdModel("id_rsa", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_rsa > /root/.ssh/id_rsa"));
        list.add(new CmdModel("id_ecdsa", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_ecdsa > /root/.ssh/id_ecdsa"));
        list.add(new CmdModel("id_ed25519", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_ed25519 > /root/.ssh/id_ed25519"));
        list.add(new CmdModel("id_dsa_pub", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_dsa.pub > /root/.ssh/id_dsa.pub"));
        list.add(new CmdModel("id_rsa_pub", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_rsa.pub > /root/.ssh/id_rsa.pub"));
        list.add(new CmdModel("id_ecdsa_pub", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_ecdsa.pub > /root/.ssh/id_ecdsa.pub"));
        list.add(new CmdModel("id_ed25519_pub", List.of("alpine_ssh", "rhel_ssh"), "cat  /id_ed25519.pub > /root/.ssh/id_ed25519.pub"));
        list.add(new CmdModel("sshd_config", List.of("alpine_ssh", "rhel_ssh"), "sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config"));
        return list;
    }

}
