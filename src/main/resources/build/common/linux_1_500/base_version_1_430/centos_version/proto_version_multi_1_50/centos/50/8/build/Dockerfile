#FROM registry.cn-qingdao.aliyuncs.com/king019/rockylinux:9
FROM registry.cn-qingdao.aliyuncs.com/king019/almalinux:8
#FROM registry.cn-qingdao.aliyuncs.com/king019/openanolis_anolisos:8
# FROM centos:8
# FROM quay.io/centos/centos:stream9


MAINTAINER king019


DKCONFIG sed_mirror almalinux_9




RUN source /etc/profile
COPY docker.sh /docker.sh
CMD /docker.sh
