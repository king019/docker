FROM  king019/centos:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft/rocketmq
RUN mkdir -p /root/tools

ADD http://nginxdown:9500/apache-rocketmq.zip /opt/soft/apache-rocketmq.zip

RUN cd /opt/soft/;unzip apache-rocketmq.zip -d rocketmq;

RUN mv /opt/soft/rocketmq /root/tools

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh