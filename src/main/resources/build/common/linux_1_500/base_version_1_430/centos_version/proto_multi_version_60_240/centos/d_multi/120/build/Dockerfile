FROM king019/centos:jdk

MAINTAINER king019



RUN dnf -y install  bind-utils
RUN dnf -y install  net-tools
RUN dnf -y install  iputils


RUN dnf -y install  jq
RUN dnf -y install  gcc
RUN dnf -y install  zlib-devel zlib

RUN dnf -y install  telnet
RUN dnf -y install  tcpdump

#base
#放入extra
RUN chmod -R 777 /*.sh



RUN chmod 755 /*.sh
CMD /docker.sh
