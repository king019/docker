FROM centos

MAINTAINER king019

COPY docker.sh /docker.sh

RUN dnf -y install wget
RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo










#RUN dnf -y update

RUN chmod 755 /*.sh


CMD /docker.sh
