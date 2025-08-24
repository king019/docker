package com.k.docker.jenkins.model.docker;


import com.google.common.collect.Maps;
import com.k.docker.jenkins.model.emums.docker.DockerFunctionEnum;
import com.k.docker.jenkins.model.emums.docker.DockerPlatformEnum;
import com.k.docker.jenkins.model.emums.docker.DockerRegionEnum;
import lombok.Data;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class DockerJenkinsModel {
    @Setter
    private static String WORKSPACE;
    @Setter
    private static String EXPERIMENTAL;
    private String path;
    //private String host;
    private String version;
    private int index;
    private DockerPlatformEnum platform;
    private Set<DockerPlatformEnum> platforms;
    private Set<DockerRegionEnum> ignoreRegions;
    private Set<DockerFunctionEnum> functions;
    private Map<DockerPlatformEnum, String> map = Maps.newHashMap();
    private String nextLine = "\n";
    private DockerRegionEnum region;
    private List<String> dockerLines;
    private boolean useCache = true;
    private boolean suffix = true;

    public String buildBuild() {
        StringBuilder sb = new StringBuilder();
        sb.append("# index ");
        sb.append(index);
        sb.append(nextLine);
        sb.append("cd ");
        if (StringUtils.isNotBlank(WORKSPACE)) {
            sb.append(WORKSPACE + "/");
        } else {
            sb.append("${WORKSPACE}/");
        }
        sb.append(path);
        sb.append(nextLine);

        {
            sb.append("docker build " + (useCache ? "" : "--no-cache ") + " -t ");
            sb.append(buildVersion(getWriteVersion(), platform));
            sb.append(" .");
            sb.append(nextLine);
        }
        map.put(platform, buildMainfest(getWriteVersion()));
        return sb.toString();
    }

    public String buildPush() {
        StringBuilder sb = new StringBuilder();
        {
            sb.append("docker push --disable-content-trust ");
            sb.append(buildVersion(getWriteVersion(), platform));
            sb.append(nextLine);
        }
        return sb.toString();
    }

    private String buildMainfest(String hostVersion) {
        StringBuilder sb = new StringBuilder();
        //docker manifest create huxl/myapp:v1 huxl/myapp-x86_64:v1 huxl/myapp-ppc64le:v1
        //docker manifest annotate huxl/myapp:v1 huxl/myapp-x86_64:v1 --os linux --arch amd64
        ///docker manifest push huxl/myapp:v1
        sb.append("docker  manifest create ");
        sb.append(" -a --insecure ");
        sb.append(hostVersion);
        sb.append(" ");
        sb.append(buildVersions(hostVersion, platforms));
        sb.append(nextLine);
        buildAnnotate(sb, hostVersion);
        sb.append(nextLine);
        sb.append("docker  manifest push -p --insecure ");
        sb.append(hostVersion);
        sb.append(nextLine);
        return sb.toString();
    }

    private void buildAnnotate(StringBuilder sb, String hostVersion) {
        for (DockerPlatformEnum platform : platforms) {
            sb.append("docker  manifest annotate ");
            sb.append(hostVersion);
            sb.append(" ");
            sb.append(buildVersion(hostVersion, platform));
            //sb.append(" --os-features linux");
            sb.append(" --os-features " + platform.getOsArch());
//            sb.append("/" + platform);
            sb.append(nextLine);
        }

    }


    private String buildVersions(String hostVersion, Set<DockerPlatformEnum> platforms) {
        String version = "";
        for (DockerPlatformEnum plat : platforms) {
            version += buildVersion(hostVersion, plat);
        }

        return version;
    }

    private String buildVersion(String hostVersion, DockerPlatformEnum platform) {
        String version = "";
        String hostVersionNow = hostVersion;
        for (DockerRegionEnum regionEnum : DockerRegionEnum.values()) {
            hostVersionNow = hostVersionNow.replace(regionEnum.getHost(), "");
        }
        if (StringUtils.contains(hostVersionNow, ":")) {
            version += hostVersion + getPlatformStr(platform) + "  ";
        } else {
            version += hostVersion + getPlatformSuffixStr(platform) + "  ";
        }
        return version;
    }

    private String getPlatformStr(DockerPlatformEnum platform) {
        return suffix ? "_" + platform.getPlatform() : "";
    }

    private String getPlatformSuffixStr(DockerPlatformEnum platform) {
        return suffix ? ":" + platform.getPlatform() : "";
    }

    private String getWriteVersion() {
        String writeVersion = version;
        if (StringUtils.isNotBlank(region.getHost())) {
            writeVersion = region.getHost() + "/" + version;
        }
        return writeVersion;
    }
}
