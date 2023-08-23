FROM  registry.cn-qingdao.aliyuncs.com/king019/docker

MAINTAINER king019

COPY config/settings.xml /root/.m2/settings.xml
COPY config/trans_maven.sh /trans_maven.sh
RUN echo 'trans_maven'


COPY config/trans.sh /trans.sh
COPY config/trans_repo_bak.sh /trans_repo_bak.sh
COPY config/trans_repo_nexus.sh /trans_repo_nexus.sh
COPY config/trans_maven.sh /trans_maven.sh
COPY config/trans_repo.sh /trans_repo.sh

RUN sed -i 's/https/http/g' /etc/apk/repositories

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

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
