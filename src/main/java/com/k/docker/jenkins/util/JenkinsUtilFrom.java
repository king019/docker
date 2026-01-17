package com.k.docker.jenkins.util;

import com.google.common.collect.Lists;
import com.k.docker.jenkins.model.docker.CmdModel;
import com.k.docker.jenkins.model.emums.command.CommonPrefixEnum;
import com.k.docker.jenkins.model.emums.command.DkConfigTypeEnum;
import com.k.docker.jenkins.model.emums.command.OptTransEnum;
import com.k.docker.jenkins.model.emums.command.cmd.base.CmdTypeEnum;
import com.k.docker.jenkins.model.emums.command.cmd.base.CommonRunCmdEnum;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class JenkinsUtilFrom {


    public void jenkinsWrite(String fromDir, String toDir) {
        File fromFileDir = new File(fromDir);
        handleFile(fromFileDir, fromDir, toDir);
    }

    public void handleFile(File fromFileDir, String fromDir, String toDir) {
        for (File file : Objects.requireNonNull(fromFileDir.listFiles())) {
            //文件处理
            if (file.isFile()) {
                copyFile(file, fromDir, toDir);
            } else {
                //文件夹处理
                handleFile(file, fromDir, toDir);
            }
        }
    }

    @SneakyThrows
    private void copyRealFile(File src, String dest) {
//        Path sourcePath = Paths.get(src);
//        Path destinationPath = Paths.get(dest);
//        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        FileUtils.copyFile(src, new File(dest), true);
    }


    @SneakyThrows
    private void copyFile(File srcfile, String fromDir, String toDir) {
        String toPath = srcfile.getAbsolutePath().replace(fromDir, toDir);
        List<String> lines = FileUtils.readLines(srcfile, StandardCharsets.UTF_8);
        if (CollectionUtils.isNotEmpty(lines)) {
            if (srcfile.getName().equals("Dockerfile")) {
                for (int i = lines.size() - 1; i >= 0; i--) {
                    handleDockerDkMultiConfigCopy(lines, i);
                }
                for (int i = lines.size() - 1; i >= 0; i--) {
                    handleDockerRunCmdCopy(fromDir, toDir, lines, toPath, i);
                }
                for (int i = lines.size() - 1; i >= 0; i--) {
                    handleDockerRunCmdTrans(lines, i);
                }
            } else {
                copyRealFile(srcfile, toPath);
            }
        }
        FileUtils.writeLines(new File(toPath), lines);
    }

    private void handleRunFileItem(String fromDir, String toDir, CmdModel fileItem, List<String> lines, int i, String buildDir) {
        if (fileItem.isRun()) {
            lines.add(i, "RUN " + fileItem.getCmdDest() + " " + fileItem.getParams());
            lines.add(i, "RUN chmod -R 777 " + fileItem.getCmdDest());
        }
        handleConfigFileItem1(fromDir, fileItem.getCmdDest(), fileItem.getCmdSrc(), lines, i);

    }


    @SneakyThrows
    private void handleConfigFileItem(int i, String srcfile, List<String> lines, String destFile) {
        List<String> fileLines = FileUtils.readLines(new File(srcfile), Charset.defaultCharset());
        String line = StringUtils.join(fileLines, "\\n");
        String start = "'";
        if (!StringUtils.contains(line, "\"")) {
            start = "\"";
        }
        if (StringUtils.contains(line, "'") && StringUtils.contains(line, "\"")) {
            throw new RuntimeException(line);
        }

        lines.add(i, "RUN echo -e " + start + "" + line + start + " > " + destFile);
    }


    private void handleDockerRunCmdCopy(String fromDir, String toDir, List<String> lines, String toPath, int i) {
        String from = lines.get(i);
        String prefix = CommonPrefixEnum.multi_run_cmd.getCode();
        if (!from.startsWith(prefix)) {
            return;
        }
        int index = from.indexOf(prefix) + prefix.length();
        String sub = from.substring(index).trim();
        List<CmdModel> multiItems = Lists.newArrayList(CommonRunCmdEnum.getMultiItem(sub));
        List<CmdModel> models = multiItems.stream().filter(cmdModel -> CmdTypeEnum.mirror.equals(cmdModel.getCmdType())).toList();
        if (CollectionUtils.isNotEmpty(models)) {
            return;
        }
        lines.remove(i);
        Collections.reverse(multiItems);
        for (CmdModel runCmdEnum : multiItems) {
            CmdTypeEnum cmdType = runCmdEnum.getCmdType();
            String cmdPre = runCmdEnum.getCmdPre();
            String cmd;
            switch (cmdType) {
                case run_shell:
                    cmd = runCmdEnum.getCmdSrc();
                    lines.add(i, cmdPre + " " + cmd);
                    break;
                case run_file:
                    handleRunFileItem(fromDir, toDir, runCmdEnum, lines, i, toPath);
                    break;
                case config_file:
                    handleConfigFileItem1(fromDir, runCmdEnum.getCmdDest(), runCmdEnum.getCmdSrc(), lines, i);
                    break;
                case mirror:
                    //from->to不处理
                    break;
            }
        }
    }

    private void handleDockerRunCmdTrans(List<String> lines, int i) {
        String line;
        for (OptTransEnum value : OptTransEnum.getList()) {
            String type = value.getType();
            switch (type) {
                case "addPre":
                    line = lines.get(i);
                    String startWith = value.getCmd();
                    if (line.contains("NO_CHANGE")) {
                        String nowCmd = line.replace("NO_CHANGE", "");
                        lines.set(i, nowCmd);
                    } else if (line.startsWith(startWith)) {
                        int indexOf = line.indexOf(startWith);
                        String subCmd = line.substring(indexOf + startWith.length() + 1);
                        String nowCmd = startWith + " " + value.getPlusCmd() + subCmd;
                        lines.set(i, nowCmd);
                    }
                    break;
                case "replace":
                    line = lines.get(i);
                    startWith = value.getCmd();
                    if (line.startsWith(startWith)) {
                        String nowCmd = line.replace(value.getPlusCmd(), value.getPlusExtCmd());
                        lines.set(i, nowCmd);
                    }
                    break;
            }
        }
    }

    private void handleConfigFileItem1(String fromDir, String destFile, String srcfile, List<String> lines, int i) {
        srcfile = fromDir + srcfile;
        handleConfigFileItem(i, srcfile, lines, destFile);
    }


    private void handleDockerDkMultiConfigCopy(List<String> lines, int i) {
        String from = lines.get(i);
        String prefix = CommonPrefixEnum.multi_config.getCode();
        if (!from.startsWith(prefix)) {
            return;
        }
        lines.remove(i);
        int index = from.indexOf(prefix) + prefix.length();
        String sub = from.substring(index).trim();
        List<DkConfigTypeEnum> fileItems = DkConfigTypeEnum.getMultiItem(sub);
        for (DkConfigTypeEnum configType : fileItems) {
            CommonPrefixEnum prefixEnum = configType.getPrefixEnum();
            lines.add(i, prefixEnum.getCode() + " " + configType.getCode());
        }
    }

}
