FROM registry.cn-qingdao.aliyuncs.com/king019/ubuntu:24.04
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

DKCONFIG multi_run_cmd baseEnv

DKCONFIG multi_run_cmd ubuntu_init

DKCONFIG multi_run_cmd ubuntu_24


COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

CMD /docker.sh
