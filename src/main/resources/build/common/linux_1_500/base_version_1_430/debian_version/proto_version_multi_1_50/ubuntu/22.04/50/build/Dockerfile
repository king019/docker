FROM registry.cn-qingdao.aliyuncs.com/king019/ubuntu:22.04
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai


RUN sed -i "s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN apt-get update



COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

CMD /docker.sh
