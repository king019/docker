FROM  ubuntu:18.04

MAINTAINER king019

RUN cd /opt/soft

ADD https://raw.githubusercontent.com/king019/docker/master/src/main/java/linux/ubuntu/18.4/build/docker.sh /docker.sh
ADD https://raw.githubusercontent.com/king019/docker/master/src/main/java/linux/ubuntu/18.4/build/sources.list /sources.list

ADD https://mirrors.aliyun.com/apache/tomcat/tomcat-8/v8.5.29/bin/apache-tomcat-8.5.29.tar.gz /opt/soft/apache-tomcat-8.5.29.tar.gz

ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.20/bin/apache-tomcat-9.0.20.tar.gz /opt/soft/apache-tomcat-9.0.20.tar.gz

ADD http://maven.aliyun.com/nexus/content/groups/public//org/eclipse/jetty/jetty-distribution/9.4.12.v20180830/jetty-distribution-9.4.12.v20180830.tar.gz /opt/soft/jetty-distribution-9.4.12.v20180830.tar.gz


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
