FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN cd /opt/soft;git clone https://gitee.com/king019/nacos.git

RUN mkdir -p /root/tools

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
