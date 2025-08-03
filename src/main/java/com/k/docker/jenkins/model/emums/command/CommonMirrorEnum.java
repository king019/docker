package com.k.docker.jenkins.model.emums.command;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

@Getter
@AllArgsConstructor
public enum CommonMirrorEnum {
    rockylinux_8("rockylinux_8", "sed-e's|^mirrorlist=|#mirrorlist=|g'-e's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'-i.bak/etc/yum.repos.d/Rocky-*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo"),
    rockylinux_9("rockylinux_9", "sed-e's|^mirrorlist=|#mirrorlist=|g'-e's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'-i.bak/etc/yum.repos.d/rocky*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo"),
    almalinux_9("almalinux_9", "sed-e's|^mirrorlist=|#mirrorlist=|g'-e's|^# baseurl=https://repo.almalinux.org|baseurl=http://mirrors.aliyun.com|g'-i.bak/etc/yum.repos.d/almalinux*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=http://nexus:8081/repository|g'  -i.bak  /etc/yum.repos.d/almalinux*.repo"),
    anolisos_8("anolisos_8", "echo 'openanolis_anolisos:8'", "sed -e 's|^baseurl=http://mirrors.openanolis.cn/|baseurl=http://nexus:8081/repository/openanolis/|g' -i.bak /etc/yum.repos.d/AnolisOS-*.repo"),


    alpine_1("alpine_1", "alpine", "sed -i 's/https/http/g' /etc/apk/repositories", ""),
    alpine_2("alpine_2", "alpine", "sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories", "sed -i 's/dl-cdn.alpinelinux.org/nexus:8081\\/repository\\/alpine/g' /etc/apk/repositories"),


    ubuntu_22_1("ubuntu_22_1", "ubuntu_22", "sed -i \"s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    ubuntu_22_2("ubuntu_22_2", "ubuntu_22", "sed -i \"s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*security.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    ubuntu_22_3("ubuntu_22_3", "ubuntu_22", "sed -i \"s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    ubuntu_22_4("ubuntu_22_4", "ubuntu_22", "apt-get update", ""),

    ubuntu_24_1("ubuntu_24_1", "ubuntu_24", "sed -i \"s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"),
    ubuntu_24_2("ubuntu_24_2", "ubuntu_24", "sed -i \"s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*security.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"),
    ubuntu_24_3("ubuntu_24_3", "ubuntu_24", "sed -i \"s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"),
    ubuntu_24_4("ubuntu_24_4", "ubuntu_24", "apt-get update", ""),


    debian_11_1("debian_11_1", "debian_11", "sed -i \"s@http://deb.debian.org@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://deb.debian.org@http://nexus:8081/repository@g\" /etc/apt/sources.list"),
    debian_11_2("debian_11_2", "debian_11", "apt-get update", ""),

    debian_12_1("debian_12_1", "debian_12", "sed -i \"s@http://deb.debian.org@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/debian.sources", "sed -i \"s@http://deb.debian.org@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/debian.sources"),
    debian_12_2("debian_12_2", "debian_12", "apt-get update", ""),


    //RUN echo 'export GO111MODULE=on' >> /etc/profile
    //RUN echo 'export GOPROXY=https://repo.huaweicloud.com/repository/goproxy/' >> /etc/profile
    //RUN echo 'export GONOSUMDB=*' >> /etc/profile
    go_proxy_1("go_proxy_1", "go_proxy", "echo 'export GO111MODULE=on' >> /etc/profile", ""),
    go_proxy_2("go_proxy_2", "go_proxy", "echo 'export GOPROXY=https://repo.huaweicloud.com/repository/goproxy/' >> /etc/profile", "echo 'export GOPROXY=http://nexus:8081/repository/go-public/' >> /etc/profile"),
    go_proxy_3("go_proxy_3", "go_proxy", "echo 'export GONOSUMDB=*' >> /etc/profile", ""),


    settings("settings", "echo 'trans_maven'", "sed -i 's/repo.huaweicloud.com/nexus:8081/g' /root/.m2/settings.xml"),


    ;


    public static Multimap<String, CommonMirrorEnum> MULTI_MAP = ArrayListMultimap.create();

    static {
        for (CommonMirrorEnum value : Arrays.stream(CommonMirrorEnum.values()).sorted(new Comparator<CommonMirrorEnum>() {
            @Override
            public int compare(CommonMirrorEnum o1, CommonMirrorEnum o2) {
                return StringUtils.compare(o2.getCode(), o1.getCode());
            }
        }).toList()) {
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
