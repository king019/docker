FROM  centos:7

MAINTAINER king019

RUN mkdir -p /soft/

ADD https://download.java.net/java/ga/jdk11/openjdk-11_linux-x64_bin.tar.gz /soft/openjdk-11_linux-x64_bin.tar.gz

RUN mkdir -p /soft
ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz

COPY docker.sh /docker.sh
CMD /docker.sh

