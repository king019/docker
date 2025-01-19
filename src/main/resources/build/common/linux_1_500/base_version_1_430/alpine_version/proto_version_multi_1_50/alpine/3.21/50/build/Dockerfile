FROM registry.cn-qingdao.aliyuncs.com/king019/alpine:3.21


RUN sed -i 's/https/http/g' /etc/apk/repositories

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2







MAINTAINER king019

RUN source /etc/profile
COPY docker.sh /docker.sh
CMD /docker.sh
