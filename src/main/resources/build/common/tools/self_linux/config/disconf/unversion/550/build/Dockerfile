FROM  king019/linux

MAINTAINER king019

RUN mkdir -p /conf

ADD conf/application.properties  /conf/application.properties
ADD conf/jdbc-mysql.properties  /conf/jdbc-mysql.properties
ADD conf/redis-config.properties  /conf/redis-config.properties
ADD conf/zoo.properties  /conf/zoo.properties



COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
