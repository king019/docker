package com.k.docker.jenkins.util;


import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PathBaseUtil {
    public static String PRE_PATH;
    public static String DOWN_PATH;
    public static List<String> REGIONS = Lists.newArrayList();

    static {
        try {
            PRE_PATH = FileUtils.readFileToString(new File(PathUtil.getResource("txt/prefix.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    static {
        try {
            REGIONS = FileUtils.readLines(new File(PathUtil.getResource("txt/region_def.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    static {
        try {
            DOWN_PATH = FileUtils.readFileToString(new File(PathUtil.getResource("txt/down.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
