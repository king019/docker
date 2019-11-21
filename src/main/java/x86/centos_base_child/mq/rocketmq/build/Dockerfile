FROM registry.cn-hangzhou.aliyuncs.com/king019/centos:centos_base

MAINTAINER king019

COPY docker.sh /docker.sh

RUN mkdir -p /opt/soft

RUN git clone https://gitee.com/king019/rocketmq.git /opt/soft/rocketmq

RUN chmod 755 /*.sh

CMD /docker.sh
