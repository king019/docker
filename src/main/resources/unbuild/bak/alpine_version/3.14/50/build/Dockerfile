FROM alpine:3.14
MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN sed -i 's/https/http/g' /etc/apk/repositories
RUN sed -i 's/dl-cdn.alpinelinux.org/repo.huaweicloud.com/g' /etc/apk/repositories

RUN mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2

RUN apk add maven
RUN apk add git
RUN apk add protobuf
RUN apk add protoc
RUN apk add openjdk8
RUN apk add openjdk11

COPY run/mvnclean.sh /mvnclean.sh
COPY config/settings.xml /root/.m2/settings.xml
RUN echo 'trans_maven'

COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
