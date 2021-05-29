FROM  king019/alpine:jdk7

MAINTAINER king019


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
