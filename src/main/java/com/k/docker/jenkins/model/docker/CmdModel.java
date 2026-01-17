package com.k.docker.jenkins.model.docker;

import com.k.docker.jenkins.model.emums.command.cmd.base.CmdTypeEnum;
import lombok.Data;

import java.util.List;

import static com.k.docker.jenkins.model.emums.docker.DockerParamEnum.CONFIG_DIR;

@Data
public class CmdModel {
    private String code;
    private String cmdSrc;
    private String cmdDest;
    private String copyFile;
    private String params;
    private boolean run;
    private List<String> groups;
    private String cmdPre = "RUN";
    private CmdTypeEnum cmdType = CmdTypeEnum.run_shell;

    public CmdModel(String code, List<String> groups, String cmdPre, String cmdSrc) {
        this.code = code;
        this.groups = groups;
        this.cmdSrc = cmdSrc;
        this.cmdPre = cmdPre;
    }

    public CmdModel(String code, List<String> groups, String cmdSrc) {
        this.code = code;
        this.groups = groups;
        this.cmdSrc = cmdSrc;
    }

    public static CmdModel mirror(String code, String group, String cmdSrc, String cmdDest) {
        CmdModel cmdModel = new CmdModel(code, List.of(group), cmdSrc);
        cmdModel.setCmdDest(cmdDest);
        cmdModel.setCmdType(CmdTypeEnum.mirror);
        return cmdModel;
    }

    public static CmdModel mirror(String code, List<String> groups, String cmdSrc, String cmdDest) {
        CmdModel cmdModel = new CmdModel(code, groups, cmdSrc);
        cmdModel.setCmdDest(cmdDest);
        cmdModel.setCmdType(CmdTypeEnum.mirror);
        return cmdModel;
    }

    public static CmdModel configFile(String code, List<String> groups, String cmdSrc, String copyFile, String cmdDest) {
        CmdModel cmdModel = new CmdModel(code, groups, CONFIG_DIR.getDef() + cmdSrc);
        cmdModel.setCopyFile(copyFile);
        cmdModel.setCmdDest(cmdDest);
        cmdModel.setCmdType(CmdTypeEnum.config_file);
        return cmdModel;
    }

    public static CmdModel runFile(String code, String group, String cmdSrc, String copyFile, String cmdDest, String params, boolean run) {
        CmdModel cmdModel = configFile(code, List.of(group), cmdSrc, copyFile, cmdDest);
        cmdModel.setParams(params);
        cmdModel.setCmdType(CmdTypeEnum.run_file);
        cmdModel.setRun(run);
        return cmdModel;
    }
}
