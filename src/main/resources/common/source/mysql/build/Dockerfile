FROM alpine

MAINTAINER king019

RUN sed -i "s/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g"

COPY docker.sh /docker.sh

RUN apk add git


RUN mkdir -p /opt/soft/version
RUN yum -y install git

RUN cd /opt/soft/version;git clone https://github.com/mysql/mysql-server.git





RUN chmod 755 /*.sh


CMD /docker.sh




