package com.k.docker.jenkins.model.emums.command.cmd.base;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.command.cmd.file.ConfigFileCmd;
import com.k.docker.jenkins.model.emums.command.cmd.file.RunFileCmd;
import com.k.docker.jenkins.model.emums.command.cmd.linux.*;
import com.k.docker.jenkins.model.emums.command.cmd.soft.alpine.SquidCmd;
import com.k.docker.jenkins.model.emums.command.cmd.soft.maven.*;
import com.k.docker.jenkins.model.emums.command.cmd.soft.mix.GiteaRunnerDockerCmd;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//DKCONFIG multi_run_cmd
@Getter
public class CommonRunCmdEnum {
    ;
    public static ListMultimap<String, CmdModel> MULTI_MAP = ArrayListMultimap.create();
    public static List<CmdModel> list = new ArrayList<>();

    static {

        list.addAll(LinuxCmd.buildCmd());
        list.addAll(ApolloCmd.buildCmd());
        list.addAll(NacosCmd.buildCmd());
        list.addAll(ServerCmd.buildCmd());
        list.addAll(SshCmd.buildCmd());
        list.addAll(ArchivaCmd.buildCmd());
        list.addAll(JenkinsCmd.buildCmd());
        list.addAll(SentinelCmd.buildCmd());
        list.addAll(ArthasCmd.buildCmd());
        list.addAll(LinuxEnvCmd.buildCmd());
        list.addAll(JdkCmd.buildCmd());
        list.addAll(DockerCmd.buildCmd());
        list.addAll(LinuxIniCmd.buildCmd());
        list.addAll(GiteaRunnerDockerCmd.buildCmd());
        list.addAll(DockerMirrorMonitorCmd.buildCmd());
        list.addAll(SquidCmd.buildCmd());
        list.addAll(SourceCmd.buildCmd());
        list.addAll(NexusCmd.buildCmd());
        list.addAll(DirAllCmd.buildCmd());
        list.addAll(MirrorCmd.buildCmd());
        list.addAll(ConfigFileCmd.buildCmd());
        list.addAll(RunFileCmd.buildCmd());
        list.addAll(RocketmqCmd.buildCmd());
        list.addAll(RocketmqConsoleCmd.buildCmd());
        list.addAll(RocketmqDashboardCmd.buildCmd());
        list.addAll(DockerInitCmd.buildCmd());
        list.addAll(IotDbBackendCmd.buildCmd());
        list.addAll(IotDbFrontendCmd.buildCmd());
        list.addAll(ZookeeperUiCmd.buildCmd());
        list.addAll(DisconfCmd.buildCmd());
        list.addAll(LuckyFrameClientCmd.buildCmd());
        list.addAll(RuoyiCloudCmd.buildCmd());
        list.addAll(StressTestPlatformCmd.buildCmd());
        for (CmdModel cmdModel : list) {
            for (String group : cmdModel.getGroups()) {
                MULTI_MAP.put(group, cmdModel);
            }
//            if (!cmdModel.getGroups().contains(cmdModel.getCode())) {
//                MULTI_MAP.put(cmdModel.getCode(), cmdModel);
//            }
        }

    }


    public static List<CmdModel> getMultiItem(String item) {
        return MULTI_MAP.get(item);
    }


}
