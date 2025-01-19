#FROM registry.cn-qingdao.aliyuncs.com/king019/rockylinux:9
FROM registry.cn-qingdao.aliyuncs.com/king019/almalinux:8
#FROM registry.cn-qingdao.aliyuncs.com/king019/openanolis_anolisos:8
# FROM centos:8
# FROM quay.io/centos/centos:stream9


MAINTAINER king019


#only  rockylinux:8
#RUN sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g' -i.bak /etc/yum.repos.d/Rocky-*.repo

#only  rockylinux:9
#RUN sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://mirrors.aliyun.com/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo


#only almalinux:9
RUN sed -e 's|^mirrorlist=|#mirrorlist=|g' -e 's|^# baseurl=https://repo.almalinux.org|baseurl=http://mirrors.aliyun.com|g'  -i.bak  /etc/yum.repos.d/almalinux*.repo


#only openanolis_anolisos:8
#RUN echo 'openanolis_anolisos:8'





RUN source /etc/profile
COPY docker.sh /docker.sh
CMD /docker.sh
