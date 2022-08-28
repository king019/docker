package com.k.docker.jenkins.model.emums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GitRemoteEnum {
    index_2("https://e.coding.net/king019/github/Sentinel.git", "http://gogs:3001/king019/Sentinel.git"),
    index_3("https://e.coding.net/king019/aliyun/ali_fw_fw.git", "http://gogs:3001/king019/ali_fw_fw.git"),
    index_4("https://e.coding.net/king019/aliyun/ali_fw_sshm.git", "http://gogs:3001/king019/ali_fw_sshm.git"),
    index_5("https://e.coding.net/king019/github/apollo.git", "http://gogs:3001/king019/apollo.git"),
    index_6("https://e.coding.net/king019/github/arthas.git", "http://gogs:3001/king019/arthas.git"),
    index_7("https://e.coding.net/king019/github/disconf.git", "http://gogs:3001/king019/disconf.git"),
    index_8("https://e.coding.net/king019/github/dubbo-admin.git", "http://gogs:3001/king019/dubbo-admin.git"),
    index_9("https://e.coding.net/king019/github/gperftools.git", "http://gogs:3001/king019/gperftools.git"),
    index_10("https://e.coding.net/king019/github/jenkins.git", "http://gogs:3001/king019/jenkins.git"),
    index_11("https://e.coding.net/king019/github/nacos.git", "http://gogs:3001/king019/nacos.git"),
    index_12("https://e.coding.net/king019/github/nexus-public.git", "http://gogs:3001/king019/nexus-public.git"),
    index_13("https://e.coding.net/king019/github/protobuf.git", "http://gogs:3001/king019/protobuf.git"),
    index_14("https://e.coding.net/king019/github/rocketmq-externals.git", "http://gogs:3001/king019/rocketmq-externals.git"),
    index_15("https://e.coding.net/king019/github/rocketmq.git", "http://gogs:3001/king019/rocketmq.git"),
    index_16("https://e.coding.net/king019/github/zkui.git", "http://gogs:3001/king019/zkui.git"),
    index_17("https://gitee.com/king019/JrebelLicenseServerforJava.git", "http://gogs:3001/king019/JrebelLicenseServerforJava.git"),
    index_18("https://gitee.com/king019/gitee_hub.git", "http://gogs:3001/king019/gitee_hub.git"),
    index_19("https://gitee.com/king019/hub_git.git", "http://gogs:3001/king019/hub_git.git"),
    index_20("https://github.com/king019/docker.git", "http://gogs:3001/king019/docker.git"),


    ;
    private String src;
    private String desc;

    public static String getDes(String src) {
        for (GitRemoteEnum remote : GitRemoteEnum.values()) {
            if (remote.src.equals(src)) {
                return remote.desc;
            }
        }
        return src;
    }

}



