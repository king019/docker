FROM  centos:7

MAINTAINER king019

RUN mkdir -p /soft/

RUN yum -y install maven git
COPY settings.xml /root/.m2/settings.xml
RUN cd /soft/ ; git clone https://github.com/king019/springbootmvc.git
RUN cd /soft/springbootmvc/mvc_lib ;mvn compile


ADD https://download.java.net/java/GA/jdk9/9.0.1/binaries/openjdk-9.0.1_linux-x64_bin.tar.gz /soft/openjdk-9.0.1_linux-x64_bin.tar.gz

ADD https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz /soft/openjdk-9.0.4_linux-x64_bin.tar.gz





ADD https://download.java.net/java/GA/jdk9/9/binaries/openjdk-9_linux-x64_bin.tar.gz /soft/openjdk-9_linux-x64_bin.tar.gz

RUN mkdir -p /soft
#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz

COPY docker.sh /docker.sh
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
EXPOSE 9876
EXPOSE 10909
EXPOSE 10911
EXPOSE 7000
