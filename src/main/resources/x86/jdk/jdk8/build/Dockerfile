FROM  registry.cn-hangzhou.aliyuncs.com/king019/centos_proto

MAINTAINER king019

RUN yum -y install java-1.8.0-openjdk-devel

RUN mkdir -p /soft


RUN yum -y install maven git
COPY settings.xml /root/.m2/settings.xml
RUN cd /soft/ ; git clone https://github.com/king019/springbootmvc.git
RUN cd /soft/springbootmvc/mvc_lib ;mvn package

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
