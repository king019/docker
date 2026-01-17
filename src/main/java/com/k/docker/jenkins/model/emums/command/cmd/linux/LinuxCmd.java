package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class LinuxCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();

        //---------------alpine_cmd---------------
        list.add(new CmdModel("git", List.of("alpine_cmd"), "apk add git"));
        list.add(new CmdModel("go", List.of("alpine_cmd"), "apk add go"));
        list.add(new CmdModel("curl", List.of("alpine_cmd"), "apk add curl"));
        list.add(new CmdModel("wget", List.of("alpine_cmd"), "apk add wget"));
        list.add(new CmdModel("vim", List.of("alpine_cmd"), "apk add vim"));
        list.add(new CmdModel("maven", List.of("alpine_cmd"), "apk add maven"));
        //---------------alpine_base_ex_cmd---------------
//        list.add(new CmdModel("net-tools", List.of("alpine_cmd"), "apk add net-tools"));
//        list.add(new CmdModel("bind-tools", List.of("alpine_cmd"), "apk add bind-tools"));
//        list.add(new CmdModel("jq", List.of("alpine_cmd"), "apk add jq"));
//        list.add(new CmdModel("busybox-extras", List.of("alpine_cmd"), "apk add busybox-extras"));
//        list.add(new CmdModel("tcpdump", List.of("alpine_cmd"), "apk add tcpdump"));
//        list.add(new CmdModel("procps", List.of("alpine_cmd"), "apk add procps"));
        //---------------alpine_cmd---------------

        //---------------rhel_cmd---------------

        list.add(new CmdModel("git_rhel", List.of("rhel_cmd", "rhel_git"), "dnf -y install  git"));
//        list.add(new CmdModel("go_rhel", List.of("rhel_cmd"), "dnf -y install  go"));
        list.add(new CmdModel("wget_rhel", List.of("rhel_cmd"), "dnf -y install  wget"));
//        list.add(new CmdModel("vim_rhel", List.of("rhel_cmd"), "dnf -y install  vim"));
        list.add(new CmdModel("rhel_install_unzip", List.of("rhel_cmd", "rhel_install_unzip"), "dnf -y install  unzip"));
        list.add(new CmdModel("which_rhel", List.of("rhel_cmd"), "dnf -y install  which"));
        list.add(new CmdModel("lsof_rhel", List.of("rhel_cmd"), "dnf -y install  lsof"));
        list.add(new CmdModel("maven_rhel", List.of("rhel_cmd"), "dnf -y install  maven"));

        //---------------rhel_base_ex_cmd---------------
//        list.add(new CmdModel("bind_utils_rhel", List.of("rhel_cmd"), "dnf -y install  bind-utils"));
//        list.add(new CmdModel("net_tools_rhel", List.of("rhel_cmd"), "dnf -y install  net-tools"));
//        list.add(new CmdModel("iputils_rhel", List.of("rhel_cmd"), "dnf -y install  iputils"));
//        list.add(new CmdModel("jq_rhel", List.of("rhel_cmd"), "dnf -y install  jq"));
//        list.add(new CmdModel("gcc_rhel", List.of("rhel_cmd"), "dnf -y install  gcc"));
//        list.add(new CmdModel("zlib_devel_rhel", List.of("rhel_cmd"), "dnf -y install  zlib-devel"));
//        list.add(new CmdModel("zlib_rhel", List.of("rhel_cmd"), "dnf -y install  zlib"));
//        list.add(new CmdModel("telnet_rhel", List.of("rhel_cmd"), "dnf -y install  telnet"));
//        list.add(new CmdModel("ltcpdump_rhel", List.of("rhel_cmd"), "dnf -y install  tcpdump"));


//---------------alpine_ex_cmd---------------


//        list.add(new CmdModel("gdb", List.of("alpine_ex_cmd"), "apk add gdb"));
//        list.add(new CmdModel("protobuf", List.of("alpine_ex_cmd"), "apk add protobuf"));
//        list.add(new CmdModel("protoc", List.of("alpine_ex_cmd"), "apk add protoc"));
//        list.add(new CmdModel("strace", List.of("alpine_ex_cmd"), "apk add strace"));
//        list.add(new CmdModel("htop", List.of("alpine_ex_cmd"), "apk add htop"));
//        list.add(new CmdModel("perf", List.of("alpine_ex_cmd"), "apk add perf"));
//        list.add(new CmdModel("thrift", List.of("alpine_ex_cmd"), "apk add thrift"));
//        list.add(new CmdModel("make", List.of("alpine_ex_cmd"), "apk add make"));
//        list.add(new CmdModel("autoconf", List.of("alpine_ex_cmd"), "apk add autoconf"));
//        list.add(new CmdModel("ttf-dejavu", List.of("alpine_ex_cmd"), "apk add ttf-dejavu"));
//        list.add(new CmdModel("rsync", List.of("alpine_ex_cmd"), "apk add rsync"));
        list.add(new CmdModel("nodejs", List.of("alpine_ex_cmd", "alpine_nodejs"), "apk add nodejs"));
        list.add(new CmdModel("npm", List.of("alpine_ex_cmd", "alpine_nodejs"), "apk add npm"));
//        list.add(new CmdModel("npm_config", List.of("alpine_ex_cmd"), "npm config set registry http://registry.npmmirror.com"));
//        list.add(new CmdModel("ca-certificates", List.of("alpine_ex_cmd"), "apk add ca-certificates"));
//        list.add(new CmdModel("bash", List.of("alpine_ex_cmd"), "apk add bash"));
//        list.add(new CmdModel("bash-doc", List.of("alpine_ex_cmd"), "apk add bash-doc"));
//        list.add(new CmdModel("bash_completion", List.of("alpine_ex_cmd"), "apk add bash-completion"));
//        list.add(new CmdModel("passwd", List.of("alpine_ex_cmd"), "sed -i 's/ash/bash/g' /etc/passwd"));
//        list.add(new CmdModel("bashrc", List.of("alpine_ex_cmd"), "source /root/.bashrc"));


        //---------------rhel_ex_cmd---------------


//        list.add(new CmdModel("nodejs_rhel", List.of("rhel_ex_cmd"), "dnf -y install  nodejs"));
//        list.add(new CmdModel("npm_config_rhel", List.of("rhel_ex_cmd"), "npm config set registry http://registry.npmmirror.com"));
//        list.add(new CmdModel("nginx_rhel", List.of("rhel_ex_cmd"), "dnf -y install  nginx"));
//        list.add(new CmdModel("gdb_rhel", List.of("rhel_ex_cmd"), "dnf -y install  gdb"));
//        list.add(new CmdModel("strace_rhel", List.of("rhel_ex_cmd"), "dnf -y install  strace"));
//        list.add(new CmdModel("traceroute_rhel", List.of("rhel_ex_cmd"), "dnf -y install  traceroute"));
//        list.add(new CmdModel("perf_rhel", List.of("rhel_ex_cmd"), "dnf -y install  perf"));
//        list.add(new CmdModel("make_rhel", List.of("rhel_ex_cmd"), "dnf -y install  make"));
//        list.add(new CmdModel("autoconf_rhel", List.of("rhel_ex_cmd"), "dnf -y install  autoconf"));
//        list.add(new CmdModel("python3_rhel", List.of("rhel_ex_cmd"), "dnf -y install  python3"));
//        list.add(new CmdModel("python3_echo_rhel", List.of("rhel_ex_cmd"), "echo \"alias python='python3'\" >> /etc/profile"));
//        list.add(new CmdModel("pip3_echo_rhel", List.of("rhel_ex_cmd"), "echo \"alias pip='pip3'\" >> /etc/profile"));
//        list.add(new CmdModel("redis_rhel", List.of("rhel_ex_cmd"), "dnf -y install  redis"));
//        list.add(new CmdModel("rsync_rhel", List.of("rhel_ex_cmd"), "dnf -y install  rsync"));
//        list.add(new CmdModel("gccpp_rhel", List.of("rhel_ex_cmd"), "dnf -y install  gcc-c++"));

//        CommonRunCmdEnum.list.addAll(list);
        return list;
    }
}
