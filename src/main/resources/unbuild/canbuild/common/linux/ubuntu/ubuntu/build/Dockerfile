FROM  king019/ubuntu:p

MAINTAINER king019
RUN cd /opt/soft


COPY docker.sh /docker.sh
#COPY sources.list /sources.list


RUN cat /sources.list>/etc/apt/sources.list



#RUN apt -y upgrade

RUN apt -y update

RUN chmod 755 /*.sh

RUN apt-get  install -y  curl
RUN apt-get  install -y  git
RUN apt-get  install -y  wget
RUN apt-get  install -y  maven
RUN apt-get  install -y  net-tools
RUN apt-get  install -y  unzip
RUN apt-get  install -y  traceroute
RUN apt-get  install -y  lsof


#RUN curl -H "Content-Type: application/json" --data '{"build": true}' -X POST https://cloud.docker.com/api/build/v1/source/3f88da41-bcf7-4eb2-8e60-85447aafd97b/trigger/a89b1189-391c-4335-bded-1838b44aea38/call/


ADD http://maven.aliyun.com/nexus/content/groups/public/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.tar.gz /opt/soft/tools/jetty-distribution-9.4.19.v20190610.tar.gz
ADD https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz /opt/soft/tools/apache-maven-3.6.3-bin.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz /opt/soft/tools/apache-tomcat-9.0.35.tar.gz



RUN cd /opt/soft/tools;tar -xzf apache-maven-3.6.3-bin.tar.gz
RUN mv /opt/soft/tools/apache-maven-3.6.3 /opt/soft/tools/maven


RUN cd /opt/soft/tools/;tar -xzf apache-tomcat-9.0.35.tar.gz
RUN cd /opt/soft/tools/;mv apache-tomcat-9.0.35 tomcat
RUN cp -r /opt/soft/tools/tomcat/ /root/tools/tomcat


#RUN echo 'export MAVEN_HOME=/opt/soft/tools/maven' >> /root/.bashrc
#RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /root/.bashrc

RUN echo 'export MAVEN_HOME=/opt/soft/tools/maven' >> /etc/profile
RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /etc/profile

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile






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
