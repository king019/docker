FROM  king019/alpine:jdk8

MAINTAINER king019
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/apollo-adminservice



COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh

RUN source /etc/profile;chmod 755 /*.sh;cp ${WS}/apollo-adminservice-release-github.zip ${WS}/apollo-adminservice/apollo-adminservice-release-github.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/apollo-adminservice;unzip apollo-adminservice-release-github.zip


CMD /docker.sh
