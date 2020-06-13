FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN cd /opt/soft;git clone https://gitee.com/king019/nacos.git

RUN mkdir -p /root/tools
RUN cp -r /opt/soft/nacos   /root/tools/nacos

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
