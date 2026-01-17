FROM king019/rhel:ssh

MAINTAINER king019

#RUN dnf -y install  git

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  git
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  wget
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  unzip
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  which
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  lsof
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven


CMD /docker.sh
