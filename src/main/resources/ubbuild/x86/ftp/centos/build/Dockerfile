FROM  centos:7

MAINTAINER king019
RUN yum -y install vsftpd
RUN yum -y install net-tools
COPY docker.sh /docker.sh
EXPOSE 21
RUN chmod 755 /*.sh
CMD /docker.sh
