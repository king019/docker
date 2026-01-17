FROM  king019/apollo:base

MAINTAINER king019

COPY dkrun.sh /dkrun.sh

RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/apollo-portal
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

RUN source /etc/profile;chmod 755 /*.sh;cp ${WS}/apollo-portal-release-github.zip ${WS}/apollo-portal/apollo-portal-release-github.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/apollo-portal;unzip apollo-portal-release-github.zip

CMD /docker.sh
