FROM docker:git

MAINTAINER king019
RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g" /etc/apk/repositories

RUN apk add openjdk11
RUN apk add maven
RUN apk add jenkins


COPY docker.sh /docker.sh

#RUN dnf -y update

RUN chmod 755 /*.sh


CMD /docker.sh
