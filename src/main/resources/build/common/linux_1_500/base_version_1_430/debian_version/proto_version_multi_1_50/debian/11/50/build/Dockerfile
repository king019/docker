FROM registry.cn-qingdao.aliyuncs.com/king019/debian:11
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai


DKCONFIG sed_mirror debian_11

RUN apt update

COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

CMD /docker.sh
