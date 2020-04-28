FROM  king019/ubuntu:p

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN cd /opt/soft

#ADD https://raw.githubusercontent.com/king019/docker/master/src/main/java/linux/ubuntu/18.4/build/docker.sh /docker.sh
#ADD https://raw.githubusercontent.com/king019/docker/master/src/main/java/linux/ubuntu/18.4/build/sources.list /sources.list

COPY docker.sh /docker.sh
#COPY sources.list /sources.list

#ADD https://mirrors.aliyun.com/apache/tomcat/tomcat-8/v8.5.42/bin/apache-tomcat-v8.5.42.tar.gz /opt/soft/apache-tomcat-v8.5.42.tar.gz

ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.20/bin/apache-tomcat-9.0.20.tar.gz /opt/soft/apache-tomcat-9.0.20.tar.gz

ADD http://maven.aliyun.com/nexus/content/groups/public/org/eclipse/jetty/jetty-distribution/9.4.12.v20180830/jetty-distribution-9.4.12.v20180830.tar.gz /opt/soft/jetty-distribution-9.4.12.v20180830.tar.gz


#RUN cat /sources.list>/etc/apt/sources.list



#RUN apt -y upgrade

RUN apt -y update

RUN chmod 755 /*.sh

RUN apt-get  install -y  curl git wget maven net-tools unzip traceroute lsof


#RUN curl -H "Content-Type: application/json" --data '{"build": true}' -X POST https://cloud.docker.com/api/build/v1/source/3f88da41-bcf7-4eb2-8e60-85447aafd97b/trigger/a89b1189-391c-4335-bded-1838b44aea38/call/


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
