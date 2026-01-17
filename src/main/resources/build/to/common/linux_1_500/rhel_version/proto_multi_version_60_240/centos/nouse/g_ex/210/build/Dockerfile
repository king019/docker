FROM king019/rhel:b

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  nodejs
RUN source /etc/profile;chmod 755 /*.sh;npm config set registry http://registry.npmmirror.com
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  nginx
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  gdb
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  strace
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  traceroute
#RUN dnf -y --enablerepo=powertools install protobuf-devel
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  perf
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install make
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install autoconf
#python
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  python3
RUN source /etc/profile;chmod 755 /*.sh;echo "alias python='python3'" >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo "alias pip='pip3'" >> /etc/profile


RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  redis
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  rsync
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  gcc-c++







RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
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
