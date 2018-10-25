FROM  centos:7

MAINTAINER king019

RUN yum -y install  automake make gcc-c++ boost-devel git wget maven

RUN yum -y install  net-tools unzip which openssh-server openssh-clients go logrotate socat

RUN yum -y install  zlib-devel rubygems ruby gem  ruby-devel ruby-docs ruby-ri ruby-irb ruby-rdoc

RUN yum -y install  traceroute lsof sysstat

RUN mkdir -p /opt/soft

RUN cd /opt/soft

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
