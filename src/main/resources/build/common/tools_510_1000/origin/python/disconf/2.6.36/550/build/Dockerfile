FROM  registry.cn-qingdao.aliyuncs.com/king019/python:2.7.18-alpine

MAINTAINER king019


DKCONFIG sed_mirror alpine



DKCONFIG mkdir_file dir_all
DKCONFIG sed_mirror go_proxy
DKCONFIG multi_file config_all

RUN apk add maven
RUN apk add openjdk8
RUN apk add git
RUN apk add python2
RUN apk add nginx




RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile


COPY conf/application.properties  /conf/application.properties
COPY conf/jdbc-mysql.properties  /conf/jdbc-mysql.properties
COPY conf/redis-config.properties  /conf/redis-config.properties
COPY conf/zoo.properties  /conf/zoo.properties

COPY nginx.conf /etc/nginx/
RUN rm -rf /etc/nginx/conf.d/default.conf




COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

CMD /docker.sh
