#FROM registry.cn-qingdao.aliyuncs.com/king019/node:14
#FROM king019/alpine:p314
FROM king019/alpine:p
DKCONFIG multi_run_cmd alpine_314

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  npm


CMD /docker.sh
