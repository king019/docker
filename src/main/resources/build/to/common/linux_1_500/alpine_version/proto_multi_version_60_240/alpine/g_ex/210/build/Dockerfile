FROM king019/alpine:b

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  npm


RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /*.sh


# 开放22端口
EXPOSE 22

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


# 执行ssh启动命令
#CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
