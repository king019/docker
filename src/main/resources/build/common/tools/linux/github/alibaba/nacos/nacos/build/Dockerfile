FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD https://github.com/alibaba/nacos/releases/download/1.3.2/nacos-server-1.3.2.zip  /opt/soft/nacos-server-1.3.2.zip
RUN mkdir -p /root/tools
RUN cp /opt/soft/nacos-server-1.3.2.zip   /root/tools/nacos-server-1.3.2.zip
RUN cd /root/tools;unzip nacos-server-1.3.2.zip
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
