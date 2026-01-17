FROM  king019/apollo:base

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/apollo-configservice


COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


RUN source /etc/profile;chmod 755 /*.sh;cp ${WS}/apollo-configservice-release-github.zip ${WS}/apollo-configservice/apollo-configservice-release-github.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/apollo-configservice;unzip apollo-configservice-release-github.zip

CMD /docker.sh
