package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.command.DkConfigTypeEnum;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class MirrorCmd {
    public static List<CmdModel> buildCmd() {
        String alpine_now_version = "v3.22";
        List<CmdModel> list = new ArrayList<>();

        list.add(CmdModel.mirror("rockylinux_8_1", "rockylinux_8", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo"));

        list.add(CmdModel.mirror("rockylinux_9_1", "rockylinux_9", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g' -i.bak /etc/yum.repos.d/rocky*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo"));

        list.add(CmdModel.mirror("almalinux_9_1", "almalinux_9", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=https://mirrors.aliyun.com|g' -i.bak /etc/yum.repos.d/almalinux*.repo", "sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=http://nexus:8081/repository|g' -i.bak /etc/yum.repos.d/almalinux*.repo"));
        list.add(CmdModel.mirror("anolisos_8_1", "anolisos_8", "echo 'openanolis_anolisos:8'", "sed -e 's|^baseurl=http://mirrors.openanolis.cn/|baseurl=http://nexus:8081/repository/openanolis/|g' -i.bak /etc/yum.repos.d/AnolisOS*.repo"));
        list.add(CmdModel.mirror("anolisos_8_2", "anolisos_8", "echo 'openanolis_anolisos:8'", "sed -e 's|^baseurl=https://mirrors.openanolis.cn/|baseurl=http://nexus:8081/repository/openanolis/|g' -i.bak /etc/yum.repos.d/AnolisOS*.repo"));


        list.add(CmdModel.mirror("openeuler_20_1", "openeuler_20", "echo 'openeuler_20'", "sed -e 's|^baseurl=https://repo.openeuler.org/|baseurl=http://nexus:8081/repository/openeuler/|g' -i.bak /etc/yum.repos.d/openEuler*.repo"));
        list.add(CmdModel.mirror("openeuler_20_2", "openeuler_20", "echo 'openeuler_20'", "sed -e 's|^gpgkey=http://repo.openeuler.org/|gpgkey=http://nexus:8081/repository/openeuler/|g' -i.bak /etc/yum.repos.d/openEuler*.repo"));
//    openeuler_20_3("openeuler_20_3", DkConfigTypeEnum.openeuler_20.getCode(), "echo 'openeuler_20'", "sed -e 's|^metalink=https://mirrors.openeuler.org/|metalink=http://nexus:8081/repository/openeuler/|g' -i.bak /etc/yum.repos.d/openEuler*.repo"),
//        list.add(CmdModel.mirror("rhel", List.of("rockylinux_8", "rockylinux_9", "almalinux_9", "anolisos_8", "openeuler_20"), "dnf list", ""));

        list.add(CmdModel.mirror("alpine_1", "alpine", "sed -i 's/https/http/g' /etc/apk/repositories", ""));
        list.add(CmdModel.mirror("alpine_2", "alpine", "sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories", "sed -i 's/dl-cdn.alpinelinux.org/nexus:8081\\/repository\\/alpine/g' /etc/apk/repositories"));
        list.add(CmdModel.mirror("alpine_2", "alpine_311", "sed -i 's/" + alpine_now_version + "/v3.11/g' /etc/apk/repositories", ""));
        list.add(CmdModel.mirror("alpine_2", "alpine_314", "sed -i 's/" + alpine_now_version + "/v3.16/g' /etc/apk/repositories", ""));
        list.add(CmdModel.mirror("alpine_2", "alpine_314", "sed -i 's/" + alpine_now_version + "/v3.18/g' /etc/apk/repositories", ""));
        list.add(CmdModel.mirror("alpine_2", "alpine_314", "sed -i 's/" + alpine_now_version + "/v3.19/g' /etc/apk/repositories", ""));
        list.add(CmdModel.mirror("alpine_2", "alpine_314", "sed -i 's/" + alpine_now_version + "/v3.22/g' /etc/apk/repositories", ""));

        //        list.add(CmdModel.mirror("alpine_1", "alpine", "apk list", ""));
//        list.add(CmdModel.mirror("alpine_1", "alpine", "mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2", ""));

        list.add(CmdModel.mirror("ubuntu_22_1", "ubuntu_22", "sed -i \"s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"));
        list.add(CmdModel.mirror("ubuntu_22_2", "ubuntu_22", "sed -i \"s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*security.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"));
        list.add(CmdModel.mirror("ubuntu_22_3", "ubuntu_22", "sed -i \"s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list"));
        list.add(CmdModel.mirror("ubuntu_22_5", "ubuntu_22", "apt-get clean", ""));
        list.add(CmdModel.mirror("ubuntu_22_6", "ubuntu_22", "apt-get update", ""));

        list.add(CmdModel.mirror("ubuntu_24_1", "ubuntu_24", "sed -i \"s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"));
        list.add(CmdModel.mirror("ubuntu_24_2", "ubuntu_24", "sed -i \"s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*security.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"));
        list.add(CmdModel.mirror("ubuntu_24_3", "ubuntu_24", "sed -i \"s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/ubuntu.sources", "sed -i \"s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/ubuntu.sources"));
        list.add(CmdModel.mirror("ubuntu_24_5", "ubuntu_24", "apt-get clean", ""));
        list.add(CmdModel.mirror("ubuntu_24_6", "ubuntu_24", "apt-get update", ""));


        list.add(CmdModel.mirror("debian_11_1", "debian_11", "sed -i \"s@http://deb.debian.org@http://repo.huaweicloud.com@g\" /etc/apt/sources.list", "sed -i \"s@http://deb.debian.org@http://nexus:8081/repository@g\" /etc/apt/sources.list"));
        list.add(CmdModel.mirror("debian_11_3", "debian_11", "apt-get clean", ""));
        list.add(CmdModel.mirror("debian_11_4", "debian_11", "apt-get update", ""));

        list.add(CmdModel.mirror("debian_12_1", "debian_12", "sed -i \"s@http://deb.debian.org@http://repo.huaweicloud.com@g\" /etc/apt/sources.list.d/debian.sources", "sed -i \"s@http://deb.debian.org@http://nexus:8081/repository@g\" /etc/apt/sources.list.d/debian.sources"));
        list.add(CmdModel.mirror("debian_12_3", "debian_12", "apt-get clean", ""));
        list.add(CmdModel.mirror("debian_12_4", "debian_12", "apt-get update", ""));


        //RUN echo 'export GO111MODULE=on' >> /etc/profile
        //RUN echo 'export GOPROXY=https://repo.huaweicloud.com/repository/goproxy/' >> /etc/profile
        //RUN echo 'export GONOSUMDB=*' >> /etc/profile
        list.add(CmdModel.mirror("go_proxy_1", DkConfigTypeEnum.go_proxy.getCode(), "echo 'export GO111MODULE=on' >> /etc/profile", ""));
        list.add(CmdModel.mirror("go_proxy_2", DkConfigTypeEnum.go_proxy.getCode(), "echo 'export GOPROXY=https://repo.huaweicloud.com/repository/goproxy/' >> /etc/profile", "echo 'export GOPROXY=http://nexus:8081/repository/go-public/' >> /etc/profile"));
        list.add(CmdModel.mirror("go_proxy_3", DkConfigTypeEnum.go_proxy.getCode(), "echo 'export GONOSUMDB=*' >> /etc/profile", ""));


        list.add(CmdModel.mirror("settings_1", "settings", "echo 'trans_maven'", "sed -i 's/repo.huaweicloud.com/nexus:8081/g' /root/.m2/settings.xml"));
        list.add(CmdModel.mirror("npm_1", "npm", "npm config set registry https://registry.npmmirror.com/", "npm config set registry http://nexus:8081/repository/npm/"));
        list.add(CmdModel.mirror("mirror_nexus_1", "mirror_nexus", "", "cd ${" + StrConstants.WS_VER + "}/nexus-public;sed -i 's/https:\\/\\/registry.npmmirror.com/http:\\/\\/nexus:8081\\/repository\\/npm/g' ./pom.xml"));

        return list;
    }

}
