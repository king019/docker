FROM king019/centos:p

MAINTAINER king019

RUN mkdir -p /root/.m2

COPY settings.xml /root/.m2/settings.xml

COPY docker.sh /docker.sh

ADD bashrc /root/.bashrc

COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


CMD /docker.sh
