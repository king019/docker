FROM king019/alpine:res

MAINTAINER king019


RUN apk add maven

#RUN apk add openjdk8
#RUN apk add openjdk11
#RUN apk add openjdk17
RUN apk add openjdk21
#RUN apk add go

RUN chmod -R 777 /*.sh


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk' >> /etc/profile

RUN chmod 755 /*.sh


CMD /docker.sh
