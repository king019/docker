FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /root/soft
RUN cd /root/soft;git clond https://gitee.com/king019/Sentinel.git
RUN cd /root/soft/Sentinel;mvn clean package


COPY docker.sh /docker.sh
CMD /docker.sh
