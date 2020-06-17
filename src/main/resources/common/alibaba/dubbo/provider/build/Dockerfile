FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://aaaaaa/dubbo-provider.jar /opt/soft/dubbo-provider.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/dubbo-provider.jar /root/tools/dubbo-provider.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
