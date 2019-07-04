FROM  ubuntu:18.04

MAINTAINER king019


COPY docker.sh /docker.sh
COPY sources.list /sources.list

RUN cat /sources.list>/etc/apt/sources.list

RUN apt -y update
RUN aptv-y upgrade
RUN chmod 755 /*.sh
CMD /docker.sh
