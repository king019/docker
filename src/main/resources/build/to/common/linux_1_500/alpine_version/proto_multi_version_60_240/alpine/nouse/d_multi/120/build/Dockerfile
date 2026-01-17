FROM king019/alpine:res

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven







RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  net-tools
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  bind-tools
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  jq
# telnet
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  busybox-extras

RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  tcpdump
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  procps



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
