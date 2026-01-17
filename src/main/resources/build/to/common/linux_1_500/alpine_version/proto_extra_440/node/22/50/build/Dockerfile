#FROM registry.cn-qingdao.aliyuncs.com/king019/node:22
#FROM king019/alpine:p322
FROM king019/alpine:p
MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  npm


CMD /docker.sh
