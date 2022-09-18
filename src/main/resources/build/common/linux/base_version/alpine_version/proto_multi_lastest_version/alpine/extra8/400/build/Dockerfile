FROM  king019/alpine:ex

MAINTAINER king019

RUN apk add openjdk8

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile
RUN chmod 755 /*.sh
CMD /docker.sh
