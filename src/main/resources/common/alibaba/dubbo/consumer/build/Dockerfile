FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://aaaaaa/dubbo-consumer.jar /opt/soft/dubbo-consumer.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/dubbo-consumer.jar /root/tools/dubbo-consumer.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
