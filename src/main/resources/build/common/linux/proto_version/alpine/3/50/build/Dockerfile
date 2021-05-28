FROM alpine
MAINTAINER king019

RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.cloud.tencent.com/g" /etc/apk/repositories

RUN apk cache

COPY docker.sh /docker.sh

RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
