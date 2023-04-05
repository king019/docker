FROM registry.cn-qingdao.aliyuncs.com/king019/ubuntu:lunar
MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN sed -i "s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list


RUN apt-get update
#RUN apt-get -y install expect
#COPY config/expect_bash.sh /expect_bash.sh


COPY docker.sh /docker.sh

COPY config/trans.sh /trans.sh
COPY config/trans_bak.sh /trans_bak.sh
COPY config/trans_nexus.sh /trans_nexus.sh


RUN chmod 755 /*.sh
#RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
