FROM registry.cn-qingdao.aliyuncs.com/king019/debian:11
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

ENV WS=/app
ENV TZ=Asia/Shanghai
ENV WS_VER=/app/ver

SHELL ["/bin/bash", "-c"]

DKCONFIG multi_run_cmd debian_11


COPY docker.sh /docker.sh



RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
