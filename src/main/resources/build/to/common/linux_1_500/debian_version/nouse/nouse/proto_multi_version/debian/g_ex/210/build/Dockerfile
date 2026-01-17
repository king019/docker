FROM king019/debian:b

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  nodejs
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  npm
RUN source /etc/profile;chmod 755 /*.sh;npm config set registry http://registry.npmmirror.com
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  nginx
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  gdb
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  strace
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  traceroute
#RUN apt-get -y install  linux-perf
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install golang-go
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install make
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install autoconf
#python
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  python3
RUN source /etc/profile;chmod 755 /*.sh;echo "alias python='python3'" >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo "alias pip='pip3'" >> /etc/profile


RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  redis
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  rsync
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install build-essential


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
