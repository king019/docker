FROM  king019/rhel:jdk

MAINTAINER king019
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN dnf -y install  curl

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun


COPY docker.sh /docker.sh
COPY docker_run.sh /docker_run.sh
RUN chmod 755 /*.sh
CMD /docker.sh
