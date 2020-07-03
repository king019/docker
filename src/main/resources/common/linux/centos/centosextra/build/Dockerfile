king019/centos:m

MAINTAINER king019

COPY docker.sh /docker.sh

RUN mkdir -p /root/soft




RUN yum -y install  automake
RUN yum -y install  make
RUN yum -y install  gcc-c++
RUN yum -y install  boost-devel
RUN yum -y install  hg
RUN yum -y install  openssh-server
RUN yum -y install  openssh-clients
RUN yum -y install  go
RUN yum -y install  logrotate
RUN yum -y install  socat
RUN yum -y install  sysstat
RUN yum -y install  mercurial






RUN chmod 755 /*.sh

CMD /docker.sh
