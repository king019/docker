package com.k.docker.jenkins.model.emums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum CommonFileEnum {
    SERVER("server.sh", "config/shell/server.sh", "server.sh", "/server.sh", -1, true),
    trans("trans.sh", "config/shell/trans/trans.sh", "trans.sh", "/trans.sh", -1, false),
    trans_maven("trans_maven.sh", "config/shell/trans/trans_maven.sh", "trans_maven.sh", "/trans_maven.sh", -1, false),
    trans_repo("trans_repo.sh", "config/shell/trans/trans_repo.sh", "trans_repo.sh", "/trans_repo.sh", -1, false),
    trans_repo_bak("trans_repo_bak.sh", "config/shell/trans/trans_repo_bak.sh", "trans_repo_bak.sh", "/trans_repo_bak.sh", -1, false),
    trans_repo_nexus("trans_repo_nexus.sh", "config/shell/trans/trans_repo_nexus.sh", "trans_repo_nexus.sh", "/trans_repo_nexus.sh", -1, false),

    bashrc("bashrc", "config/config/bashrc", "bashrc", "/root/.bashrc", -1, false),
    config("config.json", "config/config/config.json", "config.json", "/config.json", -1, false),
    daemon("daemon.json", "config/config/daemon.json", "daemon.json", "/daemon.json", -1, false),
    settings("settings.xml", "config/config/settings.xml", "settings.xml", "/root/.m2/settings.xml", -1, false),
    mvnclean("mvnclean.sh", "config/shell/mvnclean.sh", "mvnclean.sh", "/mvnclean.sh", -1, false),

    id_dsa("id_dsa", "config/config/ssh/id_dsa", "id_dsa", "/id_dsa", -1, false),
    id_dsa_pub("id_dsa.pub", "config/config/ssh/id_dsa.pub", "id_dsa.pub", "/id_dsa.pub", -1, false),
    id_ecdsa("id_ecdsa", "config/config/ssh/id_ecdsa", "id_ecdsa", "/id_ecdsa", -1, false),
    id_ecdsa_pub("id_ecdsa.pub", "config/config/ssh/id_ecdsa.pub", "id_ecdsa.pub", "/id_ecdsa.pub", -1, false),
    id_ed25519("id_ed25519", "config/config/ssh/id_ed25519", "id_ed25519", "/id_ed25519", -1, false),
    id_ed25519_pub("id_ed25519.pub", "config/config/ssh/id_ed25519.pub", "id_ed25519.pub", "/id_ed25519.pub", -1, false),
    id_rsa("id_rsa", "config/config/ssh/id_rsa", "id_rsa", "/id_rsa", -1, false),
    id_rsa_pub("id_rsa.pub", "config/config/ssh/id_rsa.pub", "id_rsa.pub", "/id_rsa.pub", -1, false),
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
