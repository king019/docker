FROM registry.cn-qingdao.aliyuncs.com/king019/ubuntu:22.04
MAINTAINER king019


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai


DKCONFIG sed_mirror ubuntu_22


COPY docker.sh /docker.sh



RUN chmod 755 /*.sh

CMD /docker.sh
