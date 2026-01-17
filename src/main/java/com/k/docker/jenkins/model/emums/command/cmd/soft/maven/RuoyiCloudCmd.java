package com.k.docker.jenkins.model.emums.command.cmd.soft.maven;

import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.constant.StrConstants;

import java.util.ArrayList;
import java.util.List;

public class RuoyiCloudCmd {
    public static List<CmdModel> buildCmd() {
        String pre = "soft_ruoyi_cloud_pre";
        String post = "soft_ruoyi_cloud_next";
        List<CmdModel> list = new ArrayList<>();

        list.add(new CmdModel("ruoyi", List.of(pre, post), "ENV", "ruoyi_cloud_version=v3.6.5"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/y_project/RuoYi-Cloud.git"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;git checkout ${ruoyi_cloud_version}"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysConfig\\\"/\\\"com.ruoyi.system.domain.SysConfig\\\"/g\" src/main/resources/mapper/system/*.xml"));

        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysDept\\\"/\\\"com.ruoyi.system.api.domain.SysDept\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysDictData\\\"/\\\"com.ruoyi.system.api.domain.SysDictData\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysDictType\\\"/\\\"com.ruoyi.system.api.domain.SysDictType\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysLogininfor\\\"/\\\"com.ruoyi.system.api.domain.SysLogininfor\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysMenu\\\"/\\\"com.ruoyi.system.domain.SysMenu\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysNotice\\\"/\\\"com.ruoyi.system.domain.SysNotice\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysOperLog\\\"/\\\"com.ruoyi.system.api.domain.SysOperLog\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysPost\\\"/\\\"com.ruoyi.system.domain.SysPost\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysRoleDept\\\"/\\\"com.ruoyi.system.domain.SysRoleDept\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysRole\\\"/\\\"com.ruoyi.system.api.domain.SysRole\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysRoleMenu\\\"/\\\"com.ruoyi.system.domain.SysRoleMenu\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysUser\\\"/\\\"com.ruoyi.system.api.domain.SysUser\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysUserPost\\\"/\\\"com.ruoyi.system.domain.SysUserPost\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i \"s/\\\"SysUserRole\\\"/\\\"com.ruoyi.system.domain.SysUserRole\\\"/g\" src/main/resources/mapper/system/*.xml"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;mvn package"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-gateway.jar  | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-auth.jar  | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-modules-system.jar | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-modules-gen.jar | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-modules-job.jar | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-modules-file.jar | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        list.add(new CmdModel("ruoyi", List.of(pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;find . -name ruoyi-visual-monitor.jar | awk -v WS=${WS} '{print \"cp \" $1  \" \" WS}' | sh"));
        {
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-gateway.jar ${WS}/ruoyi-gateway.jar"));
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-auth.jar ${WS}/ruoyi-auth.jar"));
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-modules-system.jar ${WS}/ruoyi-modules-system.jar"));
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-modules-gen.jar ${WS}/ruoyi-modules-gen.jar"));
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-modules-job.jar ${WS}/ruoyi-modules-job.jar"));
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-modules-file.jar ${WS}/ruoyi-modules-file.jar"));
            list.add(new CmdModel("ruoyi", List.of(post), "COPY", "--from=pre ${WS}/ruoyi-visual-monitor.jar ${WS}/ruoyi-visual-monitor.jar"));
        }
        {
            String ui_pre = "soft_ruoyi_cloud_ui_pre";
            String ui_post = "soft_ruoyi_cloud_ui_next";

            list.add(new CmdModel("jenkins", List.of(ui_pre), "cd ${" + StrConstants.WS_VER + "};git clone https://gitee.com/y_project/RuoYi-Cloud.git"));
            list.add(new CmdModel("jenkins", List.of(ui_pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud;git checkout ${ruoyi_cloud_version}"));
            list.add(new CmdModel("jenkins", List.of(ui_pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-ui;sed -i s/localhost:8080/ruoyi-gateway/g vue.config.js"));
            list.add(new CmdModel("jenkins", List.of(ui_pre), "cd ${" + StrConstants.WS_VER + "}/RuoYi-Cloud/ruoyi-ui;npm install "));

        }
        return list;

    }

}
