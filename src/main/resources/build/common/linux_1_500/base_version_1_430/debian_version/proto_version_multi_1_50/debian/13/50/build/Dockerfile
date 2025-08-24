FROM registry.cn-qingdao.aliyuncs.com/king019/debian:13
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai

DKCONFIG sed_mirror debian_12


COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

CMD /docker.sh
