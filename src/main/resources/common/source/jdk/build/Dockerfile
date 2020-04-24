FROM alpine

MAINTAINER king019

COPY docker.sh /docker.sh

RUN apk add git

RUN mkdir -p /opt/soft/version
RUN yum -y install git



RUN cd /opt/soft/version;git clone https://github.com/openjdk/jdk.git



RUN chmod 755 /*.sh


CMD /docker.sh

