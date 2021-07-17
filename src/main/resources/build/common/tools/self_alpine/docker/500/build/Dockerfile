FROM king019/alpine

MAINTAINER king019

RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker
RUN apk add docker


COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json


RUN chmod 755 /*.sh


CMD /docker.sh
