package com.k.docker.jenkins.consts;

import java.util.List;

public class DockerConstans {

    public static List<String> prunes = List.of("docker image prune -f", "docker volume prune -f", "docker builder prune -f");
}
