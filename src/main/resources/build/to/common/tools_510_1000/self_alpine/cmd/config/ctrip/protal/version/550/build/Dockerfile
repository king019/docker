FROM  king019/apollo:base

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/apollo-portal;unzip apollo-portal-release-github.zip



COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
