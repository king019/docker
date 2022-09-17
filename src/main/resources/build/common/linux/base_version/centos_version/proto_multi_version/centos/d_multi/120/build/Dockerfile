FROM king019/centos:jdk

MAINTAINER king019



#RUN yum list|sed -n '7,1111111p' |awk '{print "yum -y install  " $1}'
#可以使用临时关闭
#RUN sed -i "s/#baseurl/baseurl/g" /etc/yum.repos.d/CentOS-Base.repo
#RUN sed -i "s/mirrorlist=http/#mirrorlist=http/g" /etc/yum.repos.d/CentOS-Base.repo
#RUN sed -i "s@http://mirror.centos.org@https://mirrors.huaweicloud.com@g" /etc/yum.repos.d/CentOS-Base.repo

#RUN yum -y install wget
#RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.huaweicloud.com/repository/conf/CentOS-AltArch-7.repo
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo

#RUN yum clean all
#RUN yum makecache
#RUN yum -y update
#base




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
