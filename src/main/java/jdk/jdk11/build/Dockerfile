FROM  centos:7

MAINTAINER king019

RUN mkdir -p /soft/

ADD https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz /soft/openjdk-11.0.1_linux-x64_bin.tar.gz

ADD https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz /soft/openjdk-11.0.2_linux-x64_bin.tar.gz






ADD https://download.java.net/java/ga/jdk11/openjdk-11_linux-x64_bin.tar.gz /soft/openjdk-11_linux-x64_bin.tar.gz

RUN mkdir -p /soft
#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz

COPY docker.sh /docker.sh
CMD /docker.sh

