package com.k.docker.jenkins.model.emums.command.cmd.soft.alpine;

import com.k.docker.jenkins.model.docker.CmdModel;

import java.util.ArrayList;
import java.util.List;

public class SquidCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();
        list.add(new CmdModel("alpine_squid_1", List.of("alpine_squid"), "apk add squid"));
        list.add(new CmdModel("alpine_squid_2", List.of("alpine_squid"), "echo 'http_upgrade_request_protocols WebSocket allow all' >> /etc/squid/squid.conf"));
        return list;
    }

}
