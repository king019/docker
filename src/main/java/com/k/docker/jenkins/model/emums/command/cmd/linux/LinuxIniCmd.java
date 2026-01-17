package com.k.docker.jenkins.model.emums.command.cmd.linux;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class LinuxIniCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        //解决debian 使用echo  -e 将 -e添加到文件的问题
        list.add(new CmdModel("ubuntu_init_SHELL", List.of("ubuntu_init"), "SHELL", "[\"/bin/bash\", \"-c\"]"));
        list.add(new CmdModel("debian_init_SHELL", List.of("debian_init"), "SHELL", "[\"/bin/bash\", \"-c\"]"));

        list.add(new CmdModel("linux_init_bashrc", List.of("linux_init"), "echo 'source /etc/profile' >> /root/.bashrc"));
        return list;
    }
}
