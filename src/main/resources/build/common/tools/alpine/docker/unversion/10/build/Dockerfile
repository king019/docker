FROM  alpine

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml


RUN apk add maven
RUN apk add openjdk11
RUN apk add git

#RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
RUN apk add docker

RUN docker info
RUN mvn -v


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile




COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
