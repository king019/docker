FROM  king019/linux:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft/
RUN mkdir -p /root/tools

ADD http://nginxdown:9500/rocketmq-4.7.1.zip /opt/soft/rocketmq-4.7.1.zip

RUN cp /opt/soft/rocketmq-4.7.1.zip /root/tools/rocketmq-4.7.1.zip

RUN cd /root/tools/;unzip rocketmq-4.7.1.zip

RUN cd /root/tools/;mv rocketmq-4.7.1 rocketmq

RUN cd /root/tools/rocketmq/conf;echo "brokerIP1=broker" > broker.properties


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh