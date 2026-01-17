package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class SourceCmd {
    public static List<CmdModel> buildCmd() {
        List<CmdModel> list = new ArrayList<>();

        list.add(new CmdModel("source_dragonwell8", List.of("source_dragonwell8"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/alibaba/dragonwell8.git"));
        list.add(new CmdModel("source_dragonwell11", List.of("source_dragonwell11"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/alibaba/dragonwell11.git"));
        list.add(new CmdModel("source_druid", List.of("source_druid"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/druid.git"));
        list.add(new CmdModel("source_dubbo", List.of("source_dubbo"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/dubbo.git"));
        list.add(new CmdModel("source_hadoop", List.of("source_hadoop"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/hadoop.git"));
        list.add(new CmdModel("source_hbase", List.of("source_hbase"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/hbase.git"));
        list.add(new CmdModel("source_jdk", List.of("source_jdk"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/openjdk/jdk.git"));
        list.add(new CmdModel("source_kafka", List.of("source_kafka"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/kafka.git"));
        list.add(new CmdModel("source_linux", List.of("source_linux"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/torvalds/linux.git"));
        list.add(new CmdModel("source_mysql_server", List.of("source_mysql_server"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/mysql/mysql-server.git"));
        list.add(new CmdModel("source_nacos", List.of("source_nacos"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/alibaba/nacos.git"));
        list.add(new CmdModel("source_redis", List.of("source_redis"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/redis/redis.git"));
        list.add(new CmdModel("source_rocketmq", List.of("source_rocketmq"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/rocketmq.git"));
        list.add(new CmdModel("source_zookeeper", List.of("source_zookeeper"), "cd ${" + StrConstants.WS_VER + "};git clone https://github.com/apache/zookeeper.git"));

        return list;
    }

}
