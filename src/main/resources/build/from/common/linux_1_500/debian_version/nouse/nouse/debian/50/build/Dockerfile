FROM registry.cn-qingdao.aliyuncs.com/king019/debian:stable
MAINTAINER king019


RUN echo 'source /etc/profile' >> /root/.bashrc




ENV DEBIAN_FRONTEND noninteractive

DKCONFIG multi_run_cmd baseEnv

DKCONFIG multi_config dk_config_all

RUN echo "deb http://security.debian.org/debian-security stretch/updates main"  >> /etc/apt/sources.list
RUN sed -i "s@http://deb.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://security.debian.org@http://repo.huaweicloud.com@g" /etc/apt/sources.list


RUN apt-get update
RUN apt-get -y install expect





COPY docker.sh /docker.sh




RUN chmod 755 /*.sh
RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
