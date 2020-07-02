FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft/
RUN mkdir -p /root/tools

ADD http://nginxdown:9500/apache-rocketmq.zip /opt/soft/apache-rocketmq.zip

RUN cd /opt/soft/;unzip apache-rocketmq.zip

RUN cd /opt/soft/;mv apache-rocketmq rocketmq

RUN mv /opt/soft/rocketmq /root/tools


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
