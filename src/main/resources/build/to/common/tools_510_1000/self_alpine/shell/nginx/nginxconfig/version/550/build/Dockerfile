#FROM registry.cn-qingdao.aliyuncs.com/king019/node:20 as ui
#FROM king019/alpine:p319
FROM king019/alpine:p


MAINTAINER king019
ENV WS=/app
ENV TZ=Asia/Shanghai
ENV WS_VER=/app/ver

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  git
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  npm

DKCONFIG multi_run_cmd npm



COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh
CMD /docker.sh
