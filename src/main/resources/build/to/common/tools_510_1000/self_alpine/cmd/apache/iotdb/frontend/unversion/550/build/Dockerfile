FROM  king019/alpine:jdk8 as pre

MAINTAINER king019
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitcode.com/gh_mirrors/io/iotdb-web-workbench.git


COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh



EXPOSE 8080


CMD /docker.sh



