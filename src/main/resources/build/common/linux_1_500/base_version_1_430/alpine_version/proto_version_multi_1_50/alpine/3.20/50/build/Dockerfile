FROM registry.cn-qingdao.aliyuncs.com/king019/alpine:3.20


RUN sed -i 's/https/http/g' /etc/apk/repositories

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2







MAINTAINER king019
ENV TZ=Asia/Shanghai

RUN echo 'source /etc/profile' >> /root/.bashrc


RUN mkdir -p /root/.m2/repository
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

COPY docker.sh /docker.sh



COPY config/settings.xml /root/.m2/settings.xml
RUN echo 'trans_maven'
ADD config/bashrc /root/.bashrc
COPY config/config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
COPY config/daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json







COPY configshell/trans.sh /trans.sh
COPY configshell/trans_repo_bak.sh /trans_repo_bak.sh
COPY configshell/trans_repo_nexus.sh /trans_repo_nexus.sh
COPY configshell/trans_maven.sh /trans_maven.sh
COPY configshell/trans_repo.sh /trans_repo.sh












RUN apk add bash

RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
