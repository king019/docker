FROM registry.cn-beijing.aliyuncs.com/king019/debian:gitea_runner







RUN source /etc/profile;chmod 755 /*.sh;sed -i 's/repo.huaweicloud.com/nexus:8081/g' /root/.m2/settings.xml
RUN source /etc/profile;chmod 755 /*.sh;sed -i "s@http://.*archive.ubuntu.com@http://nexus:8081/repository@g" /etc/apt/sources.list
RUN source /etc/profile;chmod 755 /*.sh;sed -i "s@http://.*security.ubuntu.com@http://nexus:8081/repository@g" /etc/apt/sources.list
RUN source /etc/profile;chmod 755 /*.sh;sed -i "s@http://.*ports.ubuntu.com@http://nexus:8081/repository@g" /etc/apt/sources.list
RUN source /etc/profile;chmod 755 /*.sh;apt-get update

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
