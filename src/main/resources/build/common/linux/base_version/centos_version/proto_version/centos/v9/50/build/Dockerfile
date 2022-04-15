# FROM centos:8
# FROM quay.io/centos/centos:stream9
FROM rockylinux

MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker



# RUN minorver=8.5.2111;sed -e "s|^mirrorlist=|#mirrorlist=|g" \
#          -e "s|^#baseurl=http://mirror.centos.org/\$contentdir/\$releasever|baseurl=https://mirrors.tuna.tsinghua.edu.cn/centos-vault/$minorver|g" \
#          -i.bak \
#          /etc/yum.repos.d/CentOS-*.repo
# RUN echo 'fastestmirror=True' >> /etc/dnf/dnf.conf
# RUN dnf makecache


COPY docker.sh /docker.sh


#RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo


#从centos到centosstream
#RUN dnf -y swap centos-linux-repos centos-stream-repos
#同步安装软件到最新版
#RUN dnf -y distro-sync


RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
