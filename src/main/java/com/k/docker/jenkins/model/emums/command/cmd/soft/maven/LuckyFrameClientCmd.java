package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class LuckyFrameClientCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_lucky_frame_client_pre";
        String post = "soft_lucky_frame_client_next";
        List<CmdModel> list = new ArrayList<>();

        list.add(new CmdModel("lucky_frame", List.of(pre, post), "ENV", "lucky_frame_client_version=V3.5.2"));
        list.add(new CmdModel("lucky_frame", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/seagull1985/LuckyFrameClient.git"));
        list.add(new CmdModel("lucky_frame", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/LuckyFrameClient;git checkout ${lucky_frame_client_version}"));
        list.add(new CmdModel("lucky_frame", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/LuckyFrameClient;mvn package -Dmaven.test.skip=true"));
        list.add(new CmdModel("lucky_frame", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/LuckyFrameClient;mv target/LuckyFrameClient.jar ${WS}/LuckyFrameClient.jar"));
        {
            list.add(new CmdModel("lucky_frame", List.of(post), "COPY", "--from=pre ${WS}/LuckyFrameClient.jar ${WS}/LuckyFrameClient.jar"));
        }
        return list;

    }

}
