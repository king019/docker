FROM registry.cn-qingdao.aliyuncs.com/king019/debian:11
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

DKCONFIG multi_run_cmd baseEnv

DKCONFIG multi_run_cmd debian_init

DKCONFIG multi_run_cmd debian_11


COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

CMD /docker.sh
