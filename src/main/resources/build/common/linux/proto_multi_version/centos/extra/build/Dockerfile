king019/centos:m

MAINTAINER king019

COPY docker.sh /docker.sh

RUN mkdir -p /root/soft




RUN dnf -y install  automake
RUN dnf -y install  make
RUN dnf -y install  gcc-c++
RUN dnf -y install  boost-devel
RUN dnf -y install  hg
RUN dnf -y install  openssh-server
RUN dnf -y install  openssh-clients
RUN dnf -y install  go
RUN dnf -y install  logrotate
RUN dnf -y install  socat
RUN dnf -y install  sysstat
RUN dnf -y install  mercurial






RUN chmod 755 /*.sh

CMD /docker.sh
