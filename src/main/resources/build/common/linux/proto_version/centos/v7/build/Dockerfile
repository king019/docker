FROM centos:7

MAINTAINER king019

RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools

COPY docker.sh /docker.sh

#RUN yum install -y update

RUN chmod 755 /*.sh

CMD /docker.sh
