FROM  docker

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml

RUN sed -i 's/https/http/g' /etc/apk/repositories
RUN sed -i 's/dl-cdn.alpinelinux.org/repo.huaweicloud.com/g' /etc/apk/repositories

RUN apk add maven
RUN apk add openjdk17
RUN apk add git
RUN apk add curl

#RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
#RUN apk add docker

RUN which docker
RUN mvn -v


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile




COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
