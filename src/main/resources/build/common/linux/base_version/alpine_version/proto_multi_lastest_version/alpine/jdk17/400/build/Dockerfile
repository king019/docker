FROM  king019/alpine:b

MAINTAINER king019

RUN apk add openjdk17

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk17' >> /etc/profile

RUN chmod 755 /*.sh
CMD /docker.sh
