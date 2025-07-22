package com.k.docker.jenkins.model.emums.command;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static com.k.docker.jenkins.model.emums.DockerParamEnum.Config_dir;

@Getter
public enum CommonFileEnum {


    bashrc("bashrc", ConfigTypeEnum.config_config, "config/bashrc", "bashrc", "/root/.bashrc"),
    config("config.json", ConfigTypeEnum.config_config, "config/config.json", "config.json", "/config.json"),
    daemon("daemon.json", ConfigTypeEnum.config_config, "config/daemon.json", "daemon.json", "/daemon.json"),
    settings("settings.xml", ConfigTypeEnum.config_config, "config/settings.xml", "settings.xml", "/root/.m2/settings.xml"),
    mvnclean("mvnclean.sh", ConfigTypeEnum.config_config, "shell/mvnclean.sh", "mvnclean.sh", "/mvnclean.sh"),

    id_dsa("id_dsa", ConfigTypeEnum.config_ssh, "config/ssh/id_dsa", "id_dsa", "/id_dsa"),
    id_dsa_pub("id_dsa.pub", ConfigTypeEnum.config_ssh, "config/ssh/id_dsa.pub", "id_dsa.pub", "/id_dsa.pub"),
    id_ecdsa("id_ecdsa", ConfigTypeEnum.config_ssh, "config/ssh/id_ecdsa", "id_ecdsa", "/id_ecdsa"),
    id_ecdsa_pub("id_ecdsa.pub", ConfigTypeEnum.config_ssh, "config/ssh/id_ecdsa.pub", "id_ecdsa.pub", "/id_ecdsa.pub"),
    id_ed25519("id_ed25519", ConfigTypeEnum.config_ssh, "config/ssh/id_ed25519", "id_ed25519", "/id_ed25519"),
    id_ed25519_pub("id_ed25519.pub", ConfigTypeEnum.config_ssh, "config/ssh/id_ed25519.pub", "id_ed25519.pub", "/id_ed25519.pub"),
    id_rsa("id_rsa", ConfigTypeEnum.config_ssh, "config/ssh/id_rsa", "id_rsa", "/id_rsa"),
    id_rsa_pub("id_rsa.pub", ConfigTypeEnum.config_ssh, "config/ssh/id_rsa.pub", "id_rsa.pub", "/id_rsa.pub"),


    trans("trans.sh", ConfigTypeEnum.config_shell, "shell/trans/trans.sh", "trans.sh", "/trans.sh"),
    trans_maven("trans_maven.sh", ConfigTypeEnum.config_shell, "shell/trans/trans_maven.sh", "trans_maven.sh", "/trans_maven.sh"),
    trans_repo("trans_repo.sh", ConfigTypeEnum.config_shell, "shell/trans/trans_repo.sh", "trans_repo.sh", "/trans_repo.sh"),
    trans_repo_bak("trans_repo_bak.sh", ConfigTypeEnum.config_shell, "shell/trans/trans_repo_bak.sh", "trans_repo_bak.sh", "/trans_repo_bak.sh"),
    trans_repo_nexus("trans_repo_nexus.sh", ConfigTypeEnum.config_shell, "shell/trans/trans_repo_nexus.sh", "trans_repo_nexus.sh", "/trans_repo_nexus.sh"),

    server("server", "shell/server.sh", "server.sh", "/server.sh", true),
    ;


    public static Map<String, CommonFileEnum> MAP = Maps.uniqueIndex(Arrays.stream(CommonFileEnum.values()).iterator(), CommonFileEnum::getCode);
    public static Multimap<String, CommonFileEnum> MULTI_MAP = ArrayListMultimap.create();

    static {
        for (CommonFileEnum value : CommonFileEnum.values()) {
            ConfigTypeEnum configTypeEnum = value.getConfigType();
            if (Objects.isNull(configTypeEnum)) {
                continue;
            }
            MULTI_MAP.put(configTypeEnum.getCode(), value);
            MULTI_MAP.put(ConfigTypeEnum.config_all.getCode(), value);
        }
    }


    private String code;
    private ConfigTypeEnum configType;
    private String srcFile;
    private String copyFile;
    private String destFile;
    private int preIndex;
    private boolean run;
    private String group;

    CommonFileEnum(String code, ConfigTypeEnum configType, String srcFile, String copyFile, String destFile) {
        this.code = code;
        this.configType = configType;
        this.srcFile = Config_dir.getDef() + srcFile;
        this.copyFile = copyFile;
        this.destFile = destFile;
    }

    CommonFileEnum(String code, String srcFile, String copyFile, String destFile, boolean run) {
        this.code = code;
        this.srcFile = Config_dir.getDef() + srcFile;
        this.copyFile = copyFile;
        this.destFile = destFile;
        this.run = run;
    }

    public static CommonFileEnum getItem(String item) {
        return MAP.get(item);
    }

    public static Collection<CommonFileEnum> getMultiItem(String item) {
        return MULTI_MAP.get(item);
    }

}
