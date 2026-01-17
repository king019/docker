FROM king019/rhel:res

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven



RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  bind-utils
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  net-tools
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  iputils


RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  jq
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  gcc
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  zlib-devel zlib

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  telnet
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  tcpdump

#base
#放入extra
RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /*.sh



RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
