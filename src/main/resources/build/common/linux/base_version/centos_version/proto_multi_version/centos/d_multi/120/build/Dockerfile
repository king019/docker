FROM king019/centos:jdk

MAINTAINER king019


RUN dnf -y install  git
RUN dnf -y install  wget
RUN dnf -y install  vim
RUN dnf -y install  strace
RUN dnf -y install  net-tools
RUN dnf -y install  unzip
RUN dnf -y install  which
RUN dnf -y install  lsof
RUN dnf -y install  traceroute
RUN dnf -y install  telnet
RUN dnf -y install  tcpdump

#base
#放入extra
RUN chmod -R 777 /*.sh


RUN cd /opt/soft ; sh ./git.sh

RUN chmod 755 /*.sh
CMD /docker.sh


EXPOSE 21
EXPOSE 22
EXPOSE 3128
EXPOSE 443
EXPOSE 4000
EXPOSE 7000
EXPOSE 80
EXPOSE 888
EXPOSE 8000
EXPOSE 8080
EXPOSE 8081
EXPOSE 8443
EXPOSE 8563
EXPOSE 8888
EXPOSE 9876
EXPOSE 10909
EXPOSE 10911
