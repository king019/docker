#FROM registry.cn-qingdao.aliyuncs.com/king019/node:20 as ui
#FROM king019/alpine:p319
FROM king019/alpine:p
DKCONFIG multi_run_cmd alpine_319


MAINTAINER king019
DKCONFIG multi_run_cmd baseEnv

RUN apk add git
RUN apk add nodejs
RUN apk add npm

DKCONFIG multi_run_cmd npm



COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
