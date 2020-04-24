FROM alpine

MAINTAINER king019

RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g" /etc/apk/repositories

COPY docker.sh /docker.sh

#RUN dnf -y update

RUN chmod 755 /*.sh


CMD /docker.sh
