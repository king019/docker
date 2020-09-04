FROM king019/linux

MAINTAINER king019

RUN mkdir -p /opt/soft/

RUN mkdir -p /root/tools

ADD http://nginxdown:9500/rocketmq-console-ng.jar /opt/soft/rocketmq-console-ng.jar

RUN mv /opt/soft/rocketmq-console-ng.jar /root/tools/rocketmq-console-ng.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh