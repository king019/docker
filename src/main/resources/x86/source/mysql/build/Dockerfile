FROM centos

MAINTAINER king019

COPY docker.sh /docker.sh



RUN mkdir -p /opt/soft/version
RUN yum -y install git

RUN cd /opt/soft/version;git clone https://github.com/mysql/mysql-server.git





RUN chmod 755 /*.sh


CMD /docker.sh




