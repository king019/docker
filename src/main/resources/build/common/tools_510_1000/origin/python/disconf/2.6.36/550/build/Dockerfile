FROM  registry.cn-qingdao.aliyuncs.com/king019/python:2.7.18-alpine

MAINTAINER king019

COPY config/trans.sh /trans.sh
COPY config/trans_repo_bak.sh /trans_repo_bak.sh
COPY config/trans_repo_nexus.sh /trans_repo_nexus.sh
COPY config/trans_maven.sh /trans_maven.sh
COPY config/trans_repo.sh /trans_repo.sh

RUN sed -i 's/https/http/g' /etc/apk/repositories

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN mkdir -p /root/.m2
RUN mkdir -p /opt/soft/tool/
COPY config/settings.xml /root/.m2/settings.xml
COPY config/trans_maven.sh /trans_maven.sh
RUN echo 'trans_maven'

RUN apk add maven
RUN apk add openjdk8
RUN apk add git
RUN apk add python2
RUN apk add nginx



COPY file server.sh



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
