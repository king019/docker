FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /root/soft
RUN cd /root/soft;git clone https://gitee.com/king019/nacos.git



COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
