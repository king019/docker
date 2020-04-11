package com.k.docker.jenkins.util.model;


import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class DockerJenkinsModel {
    private String path;
    private String host;
    private String[] versions;
    private String index;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#index ");
        sb.append(index);
        sb.append("\r\n");
        sb.append("cd ");
        sb.append("${WORKSPACE}/");
        sb.append(path);
        sb.append("\r\n");
        List<String> hostVersions = Lists.newArrayList();
        for (String version : versions) {
            hostVersions.add(host + "/" + version);
        }
        for (String hostVersion : hostVersions) {
            {
                sb.append("docker build -t ");
                sb.append(hostVersion);
                sb.append(" .");
                sb.append("\r\n");
            }
            {
                sb.append("docker push ");
                sb.append(hostVersion);
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }
}
