FROM fedora

MAINTAINER king019

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /root/soft
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tools
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

COPY docker.sh /docker.sh

#RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo

#RUN dnf -y swap centos-linux-repos centos-stream-repos
#RUN dnf -y distro-sync

RUN chmod 755 /*.sh

RUN source /etc/profile

CMD /docker.sh
