FROM  king019/centos:res

MAINTAINER king019
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  maven
RUN dnf -y install  git

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun


COPY docker.sh /docker.sh
COPY docker_run.sh /docker_run.sh
RUN chmod 755 /*.sh
CMD /docker.sh
