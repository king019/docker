FROM  king019/alpine:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft/
RUN mkdir -p /root/tools

ADD http://nginxdown:9500/rocketmq-4.7.1.zip /opt/soft/rocketmq-4.7.1.zip

RUN cd /opt/soft/;unzip rocketmq-4.7.1.zip

RUN cd /opt/soft/;mv rocketmq-4.7.1 rocketmq

RUN mv /opt/soft/rocketmq /root/tools

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh