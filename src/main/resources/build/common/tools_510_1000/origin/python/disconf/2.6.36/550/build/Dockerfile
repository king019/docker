FROM  registry.cn-qingdao.aliyuncs.com/king019/python:2.7.18-alpine

MAINTAINER king019


RUN sed -i 's/https/http/g' /etc/apk/repositories
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories



RUN mkdir -p /root/.m2
RUN mkdir -p /opt/soft/tool/


RUN apk add maven
RUN apk add openjdk8
RUN apk add git
RUN apk add python2
RUN apk add nginx











RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile

RUN mkdir -p /conf

COPY conf/application.properties  /conf/application.properties
COPY conf/jdbc-mysql.properties  /conf/jdbc-mysql.properties
COPY conf/redis-config.properties  /conf/redis-config.properties
COPY conf/zoo.properties  /conf/zoo.properties

COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf


COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh
COPY file settings.xml
COPY file server.sh
RUN echo 'trans_maven'

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

CMD /docker.sh
