FROM  ubuntu:18.04

MAINTAINER king019


ADD https://raw.githubusercontent.com/king019/docker/master/src/main/java/linux/ubuntu/18.4/build/docker.sh /docker.sh
ADD https://raw.githubusercontent.com/king019/docker/master/src/main/java/linux/ubuntu/18.4/build/sources.list /sources.list

RUN cat /sources.list>/etc/apt/sources.list

RUN apt -y update
RUN apt -y upgrade
RUN chmod 755 /*.sh
CMD /docker.sh

EXPOSE 80
EXPOSE 8080
EXPOSE 8081
EXPOSE 22
EXPOSE 8000
EXPOSE 8443
EXPOSE 3128
EXPOSE 4000
EXPOSE 443
