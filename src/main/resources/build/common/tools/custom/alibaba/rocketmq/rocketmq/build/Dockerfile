FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft/
RUN mkdir -p /root/tools

ADD https://github.com/apache/rocketmq/archive/rocketmq-all-4.7.1.zip /opt/soft/rocketmq-all-4.7.1.zip

RUN cp /opt/soft/rocketmq-all-4.7.1.zip /root/tools/rocketmq-all-4.7.1.zip

RUN cd /root/tools/;unzip rocketmq-all-4.7.1.zip

RUN cd /root/tools/;mv rocketmq-4.7.1 rocketmq

RUN cd /root/tools/rocketmq/conf;echo "brokerIP1=broker" > broker.properties


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh