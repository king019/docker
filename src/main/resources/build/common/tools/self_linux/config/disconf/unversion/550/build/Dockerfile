FROM  king019/linux:jdk8

MAINTAINER king019

RUN apk add maven
RUN apk add openjdk11
RUN apk add openjdk8
RUN apk add git




RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



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
