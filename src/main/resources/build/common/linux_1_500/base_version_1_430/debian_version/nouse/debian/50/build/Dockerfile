FROM registry.cn-qingdao.aliyuncs.com/king019/debian:stable
MAINTAINER king019


RUN echo 'source /etc/profile' >> /root/.bashrc




ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai

DKCONFIG mkdir_file dir_all

RUN echo "deb http://security.debian.org/debian-security stretch/updates main"  >> /etc/apt/sources.list
RUN sed -i "s@http://deb.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://security.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list


RUN apt-get update
RUN apt-get -y install expect





COPY docker.sh /docker.sh

DKCONFIG multi_file config_all



RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json



RUN chmod 755 /*.sh
RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
