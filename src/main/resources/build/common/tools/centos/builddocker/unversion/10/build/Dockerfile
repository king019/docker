FROM  centos:8

MAINTAINER king019
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker
COPY settings.xml /root/.m2/settings.xml

RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  maven
RUN dnf -y install  git

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun

COPY config.json /config.json
RUN cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN cp /daemon.json /etc/docker/daemon.json

COPY docker.sh /docker.sh
COPY docker_run.sh /docker_run.sh
RUN chmod 755 /*.sh
CMD /docker.sh
