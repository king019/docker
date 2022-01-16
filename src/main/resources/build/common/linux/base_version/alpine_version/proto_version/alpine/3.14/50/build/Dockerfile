FROM alpine:3.14
MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.cloud.tencent.com/g" /etc/apk/repositories

RUN mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2

RUN apk add maven
RUN apk add git
RUN apk add protobuf
RUN apk add protoc



COPY config/settings.xml /root/.m2/settings.xml

COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
