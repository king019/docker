package com.k.docker.jenkins.util.model;


import com.google.common.collect.Maps;
import lombok.Data;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Data
public class DockerJenkinsModel {
    @Setter
    private static String WORKSPACE;
    private String path;
    private String host;
    private String version;
    private int index;
    private String platform;
    private String[] platforms;
    private Map<String, String> map = Maps.newHashMap();
    private String nextLine = "\n";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("# index ");
        //sb.append(index);
        sb.append(nextLine);
        sb.append("cd ");
        if (StringUtils.isNotBlank(WORKSPACE)) {
            sb.append(WORKSPACE + "/");
        } else {
            sb.append("${WORKSPACE}/");
        }
        sb.append(path);
        sb.append(nextLine);
        if (StringUtils.isNotBlank(host)) {
            version = host + "/" + version;
        }
        {
            sb.append("docker build -t ");
            sb.append(buildVersion(version, platform));
            sb.append(" .");
            sb.append(nextLine);
        }
        {
            sb.append("docker push ");
            sb.append(buildVersion(version, platform));
            sb.append(nextLine);
        }
        map.put(platform, buildMainfest(version, platform));
        return sb.toString();
    }

    private String buildMainfest(String hostVersion, String platform) {
        StringBuilder sb = new StringBuilder();
        //docker manifest create huxl/myapp:v1 huxl/myapp-x86_64:v1 huxl/myapp-ppc64le:v1
        //docker manifest annotate huxl/myapp:v1 huxl/myapp-x86_64:v1 --os linux --arch amd64
        ///docker manifest push huxl/myapp:v1
        sb.append("docker manifest create ");
        sb.append(" -a ");
        sb.append(hostVersion);
        sb.append(" ");
        sb.append(buildVersions(hostVersion, platforms));
        sb.append(nextLine);
        buildAnnotate(sb, hostVersion);
        sb.append(nextLine);
        sb.append("docker manifest push -p ");
        sb.append(hostVersion);
        sb.append(nextLine);
        return sb.toString();
    }

    private void buildAnnotate(StringBuilder sb, String hostVersion) {
        for (String platform : platforms) {
            sb.append("docker manifest annotate ");
            sb.append(hostVersion);
            sb.append(" ");
            sb.append(buildVersion(hostVersion, platform));
            //sb.append(" --os-features linux");
            sb.append(" --os-features linux");
            sb.append("/" + platform);
            sb.append(nextLine);
        }

    }

    private String buildVersions(String hostVersion, String[] platforms) {
        String version = "";
        for (String plat : platforms) {
            version += hostVersion + "_" + plat + "  ";
        }

        return version;
    }

    private String buildVersion(String hostVersion, String platform) {
        return hostVersion + "_" + platform;
    }
}
