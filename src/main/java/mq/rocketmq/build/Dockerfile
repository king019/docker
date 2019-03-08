FROM registry.cn-hangzhou.aliyuncs.com/king019/centos

MAINTAINER king019

RUN mkdir -p /opt/soft


RUN git clone https://gitee.com/king019/rocketmq.git /opt/soft/rocketmq

COPY docker.sh /docker.sh

RUN chmod 755 /*.sh

CMD /docker.sh
