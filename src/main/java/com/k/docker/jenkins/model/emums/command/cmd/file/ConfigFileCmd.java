package com.k.docker.jenkins.model.emums.command.cmd.file;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.command.ConfigTypeEnum;
import com.k.docker.jenkins.model.emums.command.DkConfigTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class ConfigFileCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();

        list.add(CmdModel.configFile("config.json", List.of(ConfigTypeEnum.config_config.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/config.json", "config.json", "/config.json"));
        list.add(CmdModel.configFile("daemon.json", List.of(ConfigTypeEnum.config_config.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/daemon.json", "daemon.json", "/daemon.json"));
        list.add(CmdModel.configFile("settings.xml", List.of(ConfigTypeEnum.config_config.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/settings.xml", "settings.xml", "/root/.m2/settings.xml"));
        list.add(CmdModel.configFile("mvnclean.sh", List.of(ConfigTypeEnum.config_config.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/mvn/mvnclean.sh", "mvnclean.sh", "/mvnclean.sh"));

        list.add(CmdModel.configFile("id_dsa", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_dsa", "id_dsa", "/id_dsa"));
        list.add(CmdModel.configFile("id_dsa.pub", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_dsa.pub", "id_dsa.pub", "/id_dsa.pub"));
        list.add(CmdModel.configFile("id_ecdsa", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_ecdsa", "id_ecdsa", "/id_ecdsa"));
        list.add(CmdModel.configFile("id_ecdsa.pub", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_ecdsa.pub", "id_ecdsa.pub", "/id_ecdsa.pub"));
        list.add(CmdModel.configFile("id_ed25519", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_ed25519", "id_ed25519", "/id_ed25519"));
        list.add(CmdModel.configFile("id_ed25519.pub", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_ed25519.pub", "id_ed25519.pub", "/id_ed25519.pub"));
        list.add(CmdModel.configFile("id_rsa", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_rsa", "id_rsa", "/id_rsa"));
        list.add(CmdModel.configFile("id_rsa.pub", List.of(ConfigTypeEnum.config_ssh.getCode(), DkConfigTypeEnum.config_all.getCode()), "config/ssh/id_rsa.pub", "id_rsa.pub", "/id_rsa.pub"));


        list.add(CmdModel.configFile("trans.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/trans/trans.sh", "trans.sh", "/trans.sh"));
        list.add(CmdModel.configFile("trans_maven.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/trans/trans_maven.sh", "trans_maven.sh", "/trans_maven.sh"));
        list.add(CmdModel.configFile("trans_repo.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/trans/trans_repo.sh", "trans_repo.sh", "/trans_repo.sh"));
        list.add(CmdModel.configFile("trans_repo_bak.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/trans/trans_repo_bak.sh", "trans_repo_bak.sh", "/trans_repo_bak.sh"));
        list.add(CmdModel.configFile("trans_repo_nexus.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/trans/trans_repo_nexus.sh", "trans_repo_nexus.sh", "/trans_repo_nexus.sh"));


        list.add(CmdModel.configFile("dkrun.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/docker/dkrun.sh", "dkrun.sh", "/dkrun.sh"));
        list.add(CmdModel.configFile("docker.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/docker/docker.sh", "docker.sh", "/docker.sh"));
        list.add(CmdModel.configFile("extra.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/docker/extra.sh", "extra.sh", "/extra.sh"));
        list.add(CmdModel.configFile("multi.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/docker/multi.sh", "multi.sh", "/multi.sh"));
        list.add(CmdModel.configFile("sshd.sh", List.of(ConfigTypeEnum.config_shell.getCode(), DkConfigTypeEnum.config_all.getCode()), "shell/docker/sshd.sh", "sshd.sh", "/sshd.sh"));

        return list;
    }
}
