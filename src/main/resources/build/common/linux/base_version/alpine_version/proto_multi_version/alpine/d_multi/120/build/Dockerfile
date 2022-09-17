FROM king019/alpine:jdk

MAINTAINER king019

RUN apk add curl
RUN apk add wget
RUN apk add vim
RUN apk add strace

# telnet
RUN apk add busybox-extras


RUN apk add htop
RUN apk add ttf-dejavu

RUN apk add tcpdump
RUN apk add procps



RUN chmod -R 777 /*.sh
RUN apk add bash bash-doc bash-completion \
    && sed -i 's/ash/bash/g' /etc/passwd \
    && source /root/.bashrc



# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
