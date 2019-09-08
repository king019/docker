FROM  centos:7

MAINTAINER king019

RUN yum -y install java-1.8.0-openjdk-devel

RUN mkdir -p /soft
#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz

COPY docker.sh /docker.sh
CMD /docker.sh

