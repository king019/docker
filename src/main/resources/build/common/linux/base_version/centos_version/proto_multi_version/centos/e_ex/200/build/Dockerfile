FROM king019/centos:m

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



RUN dnf -y install  nodejs
RUN npm config set registry https://registry.npm.taobao.org
RUN dnf -y install  nginx
RUN dnf -y install  gdb
RUN dnf -y install  strace
RUN dnf -y install  traceroute
RUN dnf -y --enablerepo=powertools install protobuf-devel
RUN dnf -y install  perf
RUN dnf -y install go
RUN dnf -y install make
RUN dnf -y install autoconf
#python
RUN dnf -y install  python3
RUN echo "alias python='python3'" >> /etc/profile
RUN echo "alias pip='pip3'" >> /etc/profile


RUN dnf -y install  redis
RUN dnf -y install  rsync
RUN dnf -y install  gcc-c++


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
