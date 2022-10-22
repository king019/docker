FROM  python:2.7.18-alpine

MAINTAINER king019

RUN sed -i 's/https/http/g' /etc/apk/repositories
RUN sed -i 's/dl-cdn.alpinelinux.org/repo.huaweicloud.com/g' /etc/apk/repositories

RUN mkdir -p /root/.m2
RUN mkdir -p /opt/soft/tools/
COPY config/settings.xml /root/.m2/settings.xml

RUN apk add maven
RUN apk add openjdk8
RUN apk add git
RUN apk add python2
RUN apk add nginx




ADD https://repo1.maven.org/maven2/org/apache/tomcat/tomcat/10.0.27/tomcat-10.0.27.tar.gz /opt/soft/tools/tomcat-10.0.27.tar.gz


RUN cd /opt/soft/tools;tar -xzf tomcat-10.0.27.tar.gz
RUN cd /opt/soft/tools;mv apache-tomcat-10.0.27 tomcat
# RUN mkdir -p /opt/soft/tools/tomcat/webapps
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile
# RUN chmod -R 777 /*.sh

RUN mkdir -p /conf

ADD conf/application.properties  /conf/application.properties
ADD conf/jdbc-mysql.properties  /conf/jdbc-mysql.properties
ADD conf/redis-config.properties  /conf/redis-config.properties
ADD conf/zoo.properties  /conf/zoo.properties

COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
