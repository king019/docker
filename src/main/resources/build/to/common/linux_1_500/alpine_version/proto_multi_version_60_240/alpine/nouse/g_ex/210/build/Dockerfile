FROM king019/alpine:b

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  gdb
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  protobuf
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  protoc
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  strace
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  htop
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  perf
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  thrift
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  make
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  autoconf
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  ttf-dejavu



RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  rsync

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  procps
#gnu
#RUN apk add gnupg

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  npm

RUN source /etc/profile;chmod 755 /*.sh;npm config set registry http://registry.npmmirror.com

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  ca-certificates






RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /*.sh

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  bash bash-doc bash-completion \
    && sed -i 's/ash/bash/g' /etc/passwd \
    && source /root/.bashrc


# 开放22端口
EXPOSE 22

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


# 执行ssh启动命令
#CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
