FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh

RUN chmod 755 /*.sh
RUN /gitjar.sh

FROM  king019/alpine:jdk8
COPY --from=pre ${WS}/rocketmq-release.zip ${WS}/rocketmq-release.zip


RUN cd ${WS};unzip rocketmq-release.zip
RUN cd ${WS};mv rocketmq-release rocketmq
#RUN cd ${WS}/rocketmq/conf;echo "brokerIP1=rocketmq_broker" > broker.properties
RUN cd ${WS}/rocketmq/conf;echo "autoCreateTopicEnable=true" >> broker.properties

COPY mqbroker_nouse.sh /mqbroker_nouse.sh
COPY mqnamesrv_nouse.sh /mqnamesrv_nouse.sh

CMD /docker.sh