FROM king019/alpine

MAINTAINER king019

ADD http://nginxdown:9500/rocketmq-console-ng.jar /opt/soft/rocketmq-console-ng.jar

RUN mv /opt/soft/rocketmq-console-ng.jar /root/tools/rocketmq-console-ng.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh