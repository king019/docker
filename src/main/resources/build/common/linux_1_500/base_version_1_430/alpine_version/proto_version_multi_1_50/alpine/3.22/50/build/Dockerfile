FROM registry.cn-qingdao.aliyuncs.com/king019/alpine:3.22


DKCONFIG sed_mirror alpine



RUN mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2







MAINTAINER king019

RUN source /etc/profile
COPY docker.sh /docker.sh
CMD /docker.sh
