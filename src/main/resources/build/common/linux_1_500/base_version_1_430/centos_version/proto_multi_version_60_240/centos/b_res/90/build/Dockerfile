FROM king019/centos:use

MAINTAINER king019

RUN mkdir -p /root/.m2




COPY file mvnclean.sh


# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


CMD /docker.sh
