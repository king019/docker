FROM king019/alpine:b

MAINTAINER king019


DKCONFIG multi_run_cmd alpine_ex_cmd


RUN chmod -R 777 /*.sh


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
#CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
