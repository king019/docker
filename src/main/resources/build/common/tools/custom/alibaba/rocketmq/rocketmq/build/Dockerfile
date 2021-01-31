FROM  king019/linux:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft/version
RUN mkdir -p /root/tools

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

# mvn -Prelease-all -DskipTests clean install

#ADD https://king019.coding.net/p/github/d/rocketmq/git/archive/rocketmq-all-4.8.0.zip /opt/soft/rocketmq-all-4.8.0.zip
#RUN cp /opt/soft/rocketmq-all-4.8.0.zip /root/tools/rocketmq-all-4.8.0.zip

RUN cd /opt/soft/;unzip rocketmq-release.zip
RUN cd /opt/soft/;mv rocketmq-release rocketmq
RUN cd /opt/soft/rocketmq/conf;echo "brokerIP1=broker" > broker.properties



CMD /docker.sh