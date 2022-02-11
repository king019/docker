FROM king019/alpine:git

MAINTAINER king019


RUN apk add maven

RUN apk add openjdk8
RUN apk add openjdk11


RUN chmod -R 777 /*.sh


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

RUN chmod 755 /*.sh


CMD /docker.sh
