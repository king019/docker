FROM  centos:8

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml

RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  maven
RUN dnf -y install  git
RUN dnf -y install  curl


RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun


RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile




COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json

COPY docker.sh /docker.sh
COPY docker_run.sh /docker_run.sh
RUN chmod 755 /*.sh
CMD /docker.sh
