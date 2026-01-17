FROM registry.cn-qingdao.aliyuncs.com/king019/alpine:3.19


DKCONFIG multi_run_cmd alpine
DKCONFIG multi_config dk_config_all


MAINTAINER king019

RUN source /etc/profile
COPY docker.sh /docker.sh
CMD /docker.sh
