FROM king019/debian:jdk

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  git
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  wget
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  vim
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  unzip
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  lsof
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  jq

RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  telnet
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  tcpdump

#base
#放入extra
RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /*.sh



RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
