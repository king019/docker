FROM registry.cn-qingdao.aliyuncs.com/king019/debian:11
MAINTAINER king019

ENV DEBIAN_FRONTEND noninteractive

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN echo "deb http://security.debian.org/debian-security stretch/updates main"  >> /etc/apt/sources.list
RUN sed -i "s@http://deb.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://security.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list


RUN apt-get update
RUN apt-get -y install expect


COPY config/expect_bash.sh /expect_bash.sh


COPY docker.sh /docker.sh

COPY config/trans.sh /trans.sh
COPY config/trans_repo_bak.sh /trans_repo_bak.sh
COPY config/trans_repo_nexus.sh /trans_repo_nexus.sh
COPY config/trans_maven.sh /trans_maven.sh
COPY config/trans_repo.sh /trans_repo.sh

RUN chmod 755 /*.sh
RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
