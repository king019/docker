package com.k.docker.jenkins.util;

public class PathUtil {

    public static String getResource() {
        String res;
        res = "src/main/resources/";
        return res;
    }

    public static String getResource(String path) {
        String res;
        res = getResource().concat(path);
        return res;
    }

    public static String getTargetPath() {
        String res;
        res = "target/";
        return res;
    }

    public static String getTargetPath(String path) {
        String res;
        res = getTargetPath() + path;
        return res;
    }

}
