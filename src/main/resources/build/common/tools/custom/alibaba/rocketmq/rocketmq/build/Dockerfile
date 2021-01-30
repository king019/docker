FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft/
RUN mkdir -p /root/tools

# mvn -Prelease-all -DskipTests clean install

ADD https://king019.coding.net/p/github/d/rocketmq/git/archive/rocketmq-all-4.8.0.zip /opt/soft/rocketmq-all-4.8.0.zip

RUN cp /opt/soft/rocketmq-all-4.8.0.zip /root/tools/rocketmq-all-4.8.0.zip

RUN cd /root/tools/;unzip rocketmq-all-4.8.0.zip

RUN cd /root/tools/;mv rocketmq-all-4.8.0 rocketmq

RUN cd /root/tools/rocketmq/conf;echo "brokerIP1=broker" > broker.properties


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh