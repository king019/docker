package com.k.docker.jenkins.model.emums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

import static com.k.docker.jenkins.model.emums.DockerParamEnum.Config_dir;

@Getter
@AllArgsConstructor
public enum CommonFileEnum {
    SERVER("server.sh", Config_dir.getDef() + "shell/server.sh", "server.sh", "/server.sh", -1, true),
    trans("trans.sh", Config_dir.getDef() + "shell/trans/trans.sh", "trans.sh", "/trans.sh", -1, false),
    trans_maven("trans_maven.sh", Config_dir.getDef() + "shell/trans/trans_maven.sh", "trans_maven.sh", "/trans_maven.sh", -1, false),
    trans_repo("trans_repo.sh", Config_dir.getDef() + "shell/trans/trans_repo.sh", "trans_repo.sh", "/trans_repo.sh", -1, false),
    trans_repo_bak("trans_repo_bak.sh", Config_dir.getDef() + "shell/trans/trans_repo_bak.sh", "trans_repo_bak.sh", "/trans_repo_bak.sh", -1, false),
    trans_repo_nexus("trans_repo_nexus.sh", Config_dir.getDef() + "shell/trans/trans_repo_nexus.sh", "trans_repo_nexus.sh", "/trans_repo_nexus.sh", -1, false),

    bashrc("bashrc", Config_dir.getDef() + "config/bashrc", "bashrc", "/root/.bashrc", -1, false),
    config("config.json", Config_dir.getDef() + "config/config.json", "config.json", "/config.json", -1, false),
    daemon("daemon.json", Config_dir.getDef() + "config/daemon.json", "daemon.json", "/daemon.json", -1, false),
    settings("settings.xml", Config_dir.getDef() + "config/settings.xml", "settings.xml", "/root/.m2/settings.xml", -1, false),
    mvnclean("mvnclean.sh", Config_dir.getDef() + "shell/mvnclean.sh", "mvnclean.sh", "/mvnclean.sh", -1, false),

    id_dsa("id_dsa", Config_dir.getDef() + "config/ssh/id_dsa", "id_dsa", "/id_dsa", -1, false),
    id_dsa_pub("id_dsa.pub", Config_dir.getDef() + "config/ssh/id_dsa.pub", "id_dsa.pub", "/id_dsa.pub", -1, false),
    id_ecdsa("id_ecdsa", Config_dir.getDef() + "config/ssh/id_ecdsa", "id_ecdsa", "/id_ecdsa", -1, false),
    id_ecdsa_pub("id_ecdsa.pub", Config_dir.getDef() + "config/ssh/id_ecdsa.pub", "id_ecdsa.pub", "/id_ecdsa.pub", -1, false),
    id_ed25519("id_ed25519", Config_dir.getDef() + "config/ssh/id_ed25519", "id_ed25519", "/id_ed25519", -1, false),
    id_ed25519_pub("id_ed25519.pub", Config_dir.getDef() + "config/ssh/id_ed25519.pub", "id_ed25519.pub", "/id_ed25519.pub", -1, false),
    id_rsa("id_rsa", Config_dir.getDef() + "config/ssh/id_rsa", "id_rsa", "/id_rsa", -1, false),
    id_rsa_pub("id_rsa.pub", Config_dir.getDef() + "config/ssh/id_rsa.pub", "id_rsa.pub", "/id_rsa.pub", -1, false),
    ;


    public static Map<String, CommonFileEnum> MAP = Maps.uniqueIndex(Arrays.stream(CommonFileEnum.values()).iterator(), CommonFileEnum::getCode);
    private String code;
    private String srcFile;
    private String copyFile;
    private String destFile;
    private int preIndex;
    private boolean run;


    public static CommonFileEnum getItem(String item) {
        return MAP.get(item);
    }
}
