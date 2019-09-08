FROM  centos:7

MAINTAINER king019

RUN mkdir -p /soft/


RUN yum -y install maven git
COPY settings.xml /root/.m2/settings.xml
RUN cd /soft/ ; git clone https://github.com/king019/springbootmvc.git


ADD https://download.java.net/java/GA/jdk10/10.0.1/fb4372174a714e6b8c52526dc134031e/10/openjdk-10.0.1_linux-x64_bin.tar.gz /soft/openjdk-10.0.1_linux-x64_bin.tar.gz

ADD https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_linux-x64_bin.tar.gz /soft/openjdk-10.0.2_linux-x64_bin.tar.gz





ADD https://download.java.net/java/GA/jdk10/10/binaries/openjdk-10_linux-x64_bin.tar.gz /soft/openjdk-10_linux-x64_bin.tar.gz

RUN mkdir -p /soft
#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /soft/apache-tomcat-9.0.24.tar.gz

COPY docker.sh /docker.sh
CMD /docker.sh

