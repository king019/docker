package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class StressTestPlatformCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_stress_test_platform_pre";
        String post = "soft_stress_test_platform_next";
        List<CmdModel> list = new ArrayList<>();

        list.add(new CmdModel("apollo_1", List.of(pre, post), "ENV", "stress_test_platform_version=V3.5.2"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/king019/stressTestPlatform.git"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/stressTestPlatform;mvn package -Dmaven.test.skip=true"));
        list.add(new CmdModel("jenkins", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/stressTestPlatform;mv target/renren-fast.jar ${WS}/renren-fast.jar"));
        {
            list.add(new CmdModel("jenkins", List.of(post), "COPY", "--from=pre ${WS}/renren-fast.jar ${WS}/renren-fast.jar"));
        }
        return list;

    }

}
