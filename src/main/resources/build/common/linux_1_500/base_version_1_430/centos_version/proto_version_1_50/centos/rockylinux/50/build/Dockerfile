#FROM registry.cn-qingdao.aliyuncs.com/king019/rockylinux:9
FROM registry.cn-qingdao.aliyuncs.com/king019/almalinux:9
#FROM registry.cn-qingdao.aliyuncs.com/king019/openanolis_anolisos:8
# FROM centos:8
# FROM quay.io/centos/centos:stream9



#only  rockylinux:8
#RUN sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo

#only  rockylinux:9
#RUN sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo


#only almalinux:9
RUN sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=https://mirrors.aliyun.com|g'  -i.bak  /etc/yum.repos.d/almalinux*.repo


#only openanolis_anolisos:8
#RUN echo 'openanolis_anolisos:8'






MAINTAINER king019


RUN echo 'source /etc/profile' >> /root/.bashrc

ENV TZ=Asia/Shanghai

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/.ssh
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker


COPY docker.sh /docker.sh

COPY configshell/trans.sh /trans.sh
COPY configshell/trans_repo_bak.sh /trans_repo_bak.sh
COPY configshell/trans_repo_nexus.sh /trans_repo_nexus.sh
COPY configshell/trans_maven.sh /trans_maven.sh
COPY configshell/trans_repo.sh /trans_repo.sh






COPY config/settings.xml /root/.m2/settings.xml
RUN echo 'trans_maven'
ADD config/bashrc /root/.bashrc
COPY config/config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
COPY config/daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json








RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
