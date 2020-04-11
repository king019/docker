FROM  registry.cn-hangzhou.aliyuncs.com/king019/centos_proto

MAINTAINER king019

RUN mkdir -p /opt/soft/version


RUN yum -y install maven git
COPY settings.xml /root/.m2/settings.xml
RUN cd /opt/soft/version ; git clone https://github.com/king019/hub_git.git

#ADD https://download.java.net/java/GA/jdk10/10.0.1/fb4372174a714e6b8c52526dc134031e/10/openjdk-10.0.1_linux-x64_bin.tar.gz /opt/soft//openjdk-10.0.1_linux-x64_bin.tar.gz

#ADD https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_linux-x64_bin.tar.gz /opt/soft//openjdk-10.0.2_linux-x64_bin.tar.gz





ADD https://repo.huaweicloud.com/openjdk/10/openjdk-10_linux-x64_bin.tar.gz /opt/soft/openjdk-10_linux-x64_bin.tar.gz

RUN mkdir -p /opt/soft/
#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /opt/soft/apache-tomcat-9.0.24.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /opt/soft/apache-tomcat-9.0.24.tar.gz

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