FROM  king019/centos:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD https://github.com/alibaba/nacos/releases/download/1.3.0/nacos-server-1.3.0.zip  /opt/soft/nacos-server-1.3.0.zip
RUN mkdir -p /root/tools
RUN cp /opt/soft/nacos-server-1.3.0.zip   /root/tools/nacos-server-1.3.0.zip
RUN cd /root/tools;unzip nacos-server-1.3.0.zip
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
