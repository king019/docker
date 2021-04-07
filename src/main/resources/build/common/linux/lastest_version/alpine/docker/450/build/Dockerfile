FROM king019/alpine

MAINTAINER king019


RUN apk add docker


COPY config.json /config.json
RUN mkdir /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir /etc/docker;cp /daemon.json /etc/docker/daemon.json


RUN chmod 755 /*.sh


CMD /docker.sh
