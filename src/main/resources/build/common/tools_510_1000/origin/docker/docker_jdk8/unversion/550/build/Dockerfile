FROM  registry.cn-qingdao.aliyuncs.com/king019/docker

MAINTAINER king019








RUN sed -i 's/https/http/g' /etc/apk/repositories

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN apk add maven
#RUN apk add openjdk17
#RUN apk add openjdk11
RUN apk add openjdk8
RUN apk add git
RUN apk add curl

#RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
#RUN apk add docker

RUN which docker
RUN mvn -v


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

COPY file settings.xml
COPY file daemon.json
COPY file config.json
COPY file bashrc
COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh



RUN echo 'trans_maven'


RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
