FROM king019/centos:b

MAINTAINER king019


RUN dnf -y install  nodejs
RUN npm config set registry http://registry.npmmirror.com
RUN dnf -y install  nginx
RUN dnf -y install  gdb
RUN dnf -y install  strace
RUN dnf -y install  traceroute
#RUN dnf -y --enablerepo=powertools install protobuf-devel
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





RUN dnf -y install  java-1.8.0-openjdk
RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  java-17-openjdk-devel
RUN dnf -y install  java-21-openjdk-devel






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
