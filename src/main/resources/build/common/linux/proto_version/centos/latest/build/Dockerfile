FROM centos

MAINTAINER king019

COPY docker.sh /docker.sh

RUN dnf -y install wget
RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo



COPY config.json /config.json
RUN mkdir /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir /etc/docker;cp /daemon.json /etc/docker/daemon.json






#RUN dnf -y update

RUN chmod 755 /*.sh


CMD /docker.sh
