FROM registry.cn-qingdao.aliyuncs.com/king019/debian:stable
MAINTAINER king019


RUN echo 'source /etc/profile' >> /root/.bashrc




ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN echo "deb http://security.debian.org/debian-security stretch/updates main"  >> /etc/apt/sources.list
RUN sed -i "s@http://deb.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://security.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list


RUN apt-get update
RUN apt-get -y install expect





COPY docker.sh /docker.sh

COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh

COPY file settings.xml
COPY file daemon.json
COPY file config.json
COPY file bashrc


RUN echo 'trans_maven'
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json



RUN chmod 755 /*.sh
RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
