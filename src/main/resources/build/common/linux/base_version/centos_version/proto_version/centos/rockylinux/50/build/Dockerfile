FROM registry.cn-qingdao.aliyuncs.com/king019/rockylinux:9
#FROM almalinux:9
# FROM centos:8
# FROM quay.io/centos/centos:stream9
MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker


#only  rockylinux:8
#RUN sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo

#only  rockylinux:9
RUN sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo


#only almalinux
#RUN sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=https://mirrors.aliyun.com|g'  -i.bak  /etc/yum.repos.d/almalinux*.repo

COPY docker.sh /docker.sh

COPY config/trans.sh /trans.sh
COPY config/trans_bak.sh /trans_bak.sh
COPY config/trans_nexus.sh /trans_nexus.sh


RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
