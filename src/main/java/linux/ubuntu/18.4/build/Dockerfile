FROM  ubuntu:18.04

MAINTAINER king019


COPY docker.sh /docker.sh
COPY sources.list /sources.list

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
