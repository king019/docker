FROM king019/docker:p

MAINTAINER king019


COPY settings.xml /root/.m2/settings.xml

COPY docker.sh /docker.sh

RUN apk add git
RUN apk add openjdk11
RUN apk add openjdk8
RUN apk add maven


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

COPY config.json /config.json
RUN mkdir /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir /etc/docker;cp /daemon.json /etc/docker/daemon.json

RUN chmod 755 /*.sh


CMD /docker.sh
