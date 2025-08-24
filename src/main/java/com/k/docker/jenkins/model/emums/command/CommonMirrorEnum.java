package com.k.docker.jenkins.model.emums.command;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;

@Getter
@AllArgsConstructor
public enum
CommonMirrorEnum {
    rockylinux_8("rockylinux_8", DkConfigTypeEnum.rockylinux_8.getCode(), "sed-e's|^mirrorlist=|#mirrorlist=|g'-e's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'-i.bak/etc/yum.repos.d/Rocky-*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo"),
    rockylinux_9("rockylinux_9", DkConfigTypeEnum.rockylinux_9.getCode(), "sed-e's|^mirrorlist=|#mirrorlist=|g'-e's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'-i.bak/etc/yum.repos.d/rocky*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo"),
    almalinux_9("almalinux_9", DkConfigTypeEnum.almalinux_9.getCode(), "sed-e's|^mirrorlist=|#mirrorlist=|g'-e's|^# baseurl=https://repo.almalinux.org|baseurl=http://mirrors.aliyun.com|g'-i.bak/etc/yum.repos.d/almalinux*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=http://nexus:8081/repository|g'  -i.bak  /etc/yum.repos.d/almalinux*.repo"),
    anolisos_8("anolisos_8", DkConfigTypeEnum.anolisos_8.getCode(), "echo 'openanolis_anolisos:8'", "sed -e 's|^baseurl=http://mirrors.openanolis.cn/|baseurl=http://nexus:8081/repository/openanolis/|g' -i.bak /etc/yum.repos.d/AnolisOS-*.repo"),


    alpine_1("alpine_1", DkConfigTypeEnum.alpine.getCode(), "sed -i 's/https/http/g' /etc/apk/repositories", ""),
    alpine_2("alpine_2", DkConfigTypeEnum.alpine.getCode(), "sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories", "sed -i 's/dl-cdn.alpinelinux.org/nexus:8081\\/repository\\/alpine/g' /etc/apk/repositories"),


    ubuntu_22_1("ubuntu_22_1", DkConfigTypeEnum.ubuntu_22.getCode(), "sed -i \"s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    ubuntu_22_2("ubuntu_22_2", DkConfigTypeEnum.ubuntu_22.getCode(), "sed -i \"s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*security.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    ubuntu_22_3("ubuntu_22_3", DkConfigTypeEnum.ubuntu_22.getCode(), "sed -i \"s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    ubuntu_22_5("ubuntu_22_5", DkConfigTypeEnum.ubuntu_22.getCode(), "apt-get clean", ""),
    ubuntu_22_6("ubuntu_22_6", DkConfigTypeEnum.ubuntu_22.getCode(), "apt-get update", ""),

    ubuntu_24_1("ubuntu_24_1", DkConfigTypeEnum.ubuntu_24.getCode(), "sed -i \"s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"),
    ubuntu_24_2("ubuntu_24_2", DkConfigTypeEnum.ubuntu_24.getCode(), "sed -i \"s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*security.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"),
    ubuntu_24_3("ubuntu_24_3", DkConfigTypeEnum.ubuntu_24.getCode(), "sed -i \"s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"),
    ubuntu_24_5("ubuntu_24_5", DkConfigTypeEnum.ubuntu_24.getCode(), "apt-get clean", ""),
    ubuntu_24_6("ubuntu_24_6", DkConfigTypeEnum.ubuntu_24.getCode(), "apt-get update", ""),


    debian_11_1("debian_11_1", DkConfigTypeEnum.debian_11.getCode(), "sed -i \"s@http://deb.debian.org@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://deb.debian.org@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    debian_11_3("debian_11_3", DkConfigTypeEnum.debian_11.getCode(), "apt-get clean", ""),
    debian_11_4("debian_11_4", DkConfigTypeEnum.debian_11.getCode(), "apt-get update", ""),

    debian_12_1("debian_12_1", DkConfigTypeEnum.debian_12.getCode(), "sed -i \"s@http://deb.debian.org@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/debian.sources", "sed -i \"s@http://deb.debian.org@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/debian.sources"),
    debian_12_4("debian_12_3", DkConfigTypeEnum.debian_12.getCode(), "apt-get clean", ""),
    debian_12_5("debian_12_4", DkConfigTypeEnum.debian_12.getCode(), "apt-get update", ""),


    //RUN echo 'export GO111MODULE=on' >> /etc/profile
    //RUN echo 'export GOPROXY=https://repo.huaweicloud.com/repository/goproxy/' >> /etc/profile
    //RUN echo 'export GONOSUMDB=*' >> /etc/profile
    go_proxy_1("go_proxy_1", DkConfigTypeEnum.go_proxy.getCode(), "echo 'export GO111MODULE=on' >> /etc/profile", ""),
    go_proxy_2("go_proxy_2", DkConfigTypeEnum.go_proxy.getCode(), "echo 'export GOPROXY=https://repo.huaweicloud.com/repository/goproxy/' >> /etc/profile", "echo 'export GOPROXY=http://nexus:8081/repository/go-public/' >> /etc/profile"),
    go_proxy_3("go_proxy_3", DkConfigTypeEnum.go_proxy.getCode(), "echo 'export GONOSUMDB=*' >> /etc/profile", ""),


    settings("settings", "echo 'trans_maven'", "sed -i 's/repo.huaweicloud.com/nexus:8081/g' /root/.m2/settings.xml"),

    docker_1("docker_1", DkConfigTypeEnum.docker.getCode(), "mkdir -p /root/.docker;cp /config.json /root/.docker/config.json", "mkdir -p /root/.docker;cp /config.json /root/.docker/config.json"),
    docker_2("docker_2", DkConfigTypeEnum.docker.getCode(), "mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json", "mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json"),


    ;


    public static Multimap<String, CommonMirrorEnum> MULTI_MAP = ArrayListMultimap.create();

    static {
        for (CommonMirrorEnum value : Arrays.stream(CommonMirrorEnum.values()).sorted((o1, o2) -> StringUtils.compare(o2.getCode(), o1.getCode())).toList()) {
            MULTI_MAP.put(StringUtils.defaultIfBlank(value.group, value.code), value);
        }
    }

    private String code;
    private String group;
    private String srcCmd;
    private String destCmd;


    CommonMirrorEnum(String code, String srcCmd, String destCmd) {
        this.code = code;
        this.srcCmd = srcCmd;
        this.destCmd = destCmd;
    }

    public static Collection<CommonMirrorEnum> getMultiItem(String item) {
        return MULTI_MAP.get(item);
    }

}
