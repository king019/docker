FROM  king019/linux

MAINTAINER king019
ADD https://github.com/alibaba/nacos/releases/download/2.0.0/nacos-server-2.0.0.zip  /opt/soft/nacos-server-2.0.0.zip
RUN cp /opt/soft/nacos-server-2.0.0.zip   /root/tools/nacos-server-2.0.0.zip
RUN cd /root/tools;unzip nacos-server-2.0.0.zip
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
