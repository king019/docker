FROM  king019/linux:jdk8

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
COPY gitjar.sh /mqbroker.sh
COPY docker.sh /mqnamesrv.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


RUN cd /opt/soft/;unzip rocketmq-release.zip
RUN cd /opt/soft/;mv rocketmq-release rocketmq
#RUN cd /opt/soft/rocketmq/conf;echo "brokerIP1=rocketmq_broker" > broker.properties



CMD /docker.sh