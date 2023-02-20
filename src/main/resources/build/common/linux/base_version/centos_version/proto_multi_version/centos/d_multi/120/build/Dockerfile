FROM king019/centos:jdk

MAINTAINER king019


RUN dnf -y install  git
RUN dnf -y install  wget
RUN dnf -y install  vim
RUN dnf -y install  bind-utils
RUN dnf -y install  net-tools
RUN dnf -y install  iputils
RUN dnf -y install  unzip
RUN dnf -y install  which
RUN dnf -y install  lsof

RUN dnf -y install  telnet
RUN dnf -y install  tcpdump

#base
#放入extra
RUN chmod -R 777 /*.sh


RUN cd /opt/soft ; sh ./git.sh

RUN chmod 755 /*.sh
CMD /docker.sh
