FROM king019/debian:b

MAINTAINER king019


RUN apt-get -y install  nodejs
RUN apt-get -y install  npm
RUN npm config set registry https://registry.npm.taobao.org
RUN apt-get -y install  nginx
RUN apt-get -y install  gdb
RUN apt-get -y install  strace
RUN apt-get -y install  traceroute
#RUN apt-get -y install  linux-perf
RUN apt-get -y install golang-go
RUN apt-get -y install make
RUN apt-get -y install autoconf
#python
RUN apt-get -y install  python3
RUN echo "alias python='python3'" >> /etc/profile
RUN echo "alias pip='pip3'" >> /etc/profile


RUN apt-get -y install  redis
RUN apt-get -y install  rsync
RUN apt-get -y install build-essential


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
