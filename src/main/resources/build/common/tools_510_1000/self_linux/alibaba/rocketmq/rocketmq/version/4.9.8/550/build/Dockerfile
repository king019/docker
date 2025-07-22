FROM  king019/linux:jdk8 as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh

RUN chmod 755 /*.sh
RUN /gitjar.sh

FROM  king019/linux:jdk8
COPY --from=pre /opt/soft/rocketmq-release.zip /opt/soft/rocketmq-release.zip


RUN cd /opt/soft/;unzip rocketmq-release.zip
RUN cd /opt/soft/;mv rocketmq-release rocketmq
#RUN cd /opt/soft/rocketmq/conf;echo "brokerIP1=rocketmq_broker" > broker.properties
RUN cd /opt/soft/rocketmq/conf;echo "autoCreateTopicEnable=true" >> broker.properties

COPY mqbroker_nouse.sh /mqbroker_nouse.sh
COPY mqnamesrv_nouse.sh /mqnamesrv_nouse.sh

CMD /docker.sh