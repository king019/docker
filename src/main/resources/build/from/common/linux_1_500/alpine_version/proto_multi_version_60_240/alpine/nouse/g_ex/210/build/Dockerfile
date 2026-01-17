FROM king019/alpine:b

MAINTAINER king019

RUN apk add gdb
RUN apk add protobuf
RUN apk add protoc
RUN apk add strace
RUN apk add htop
RUN apk add perf
RUN apk add thrift
RUN apk add make
RUN apk add autoconf
RUN apk add ttf-dejavu



RUN apk add rsync

RUN apk add procps
#gnu
#RUN apk add gnupg

RUN apk add nodejs
RUN apk add npm

RUN npm config set registry http://registry.npmmirror.com

RUN apk add ca-certificates






RUN chmod -R 777 /*.sh

RUN apk add bash bash-doc bash-completion \
    && sed -i 's/ash/bash/g' /etc/passwd \
    && source /root/.bashrc


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
#CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
