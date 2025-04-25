package com.k.docker.jenkins.util;

public class PathUtil {
    private static String getBase() {
        return PathUtil.class.getClassLoader().getResource("").getPath().replace("target/classes/", "");
    }

    public static String getResource() {
        String res;
        res = getBase() + "src/main/resources/";
        return res;
    }

    public static String getResource(String path) {
        String res;
        res = getResource().concat(path);
        return res;
    }

    public static String getTargetPath() {
        String res;
        res = getBase() + "target/";
        return res;
    }

    public static String getTargetPath(String path) {
        String res;
        res = getTargetPath() + path;
        return res;
    }

}
