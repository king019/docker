FROM  centos:7

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml

RUN yum -y install  java-11-openjdk-devel
RUN yum -y install  maven
RUN yum -y install  git

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



#RUN dnf install  https://download.docker.com/linux/centos/8/x86_64/stable/Packages/containerd.io-1.3.7-3.1.el8.x86_64.rpm
RUN curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun

COPY config.json /config.json
RUN mkdir /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir /etc/docker;cp /daemon.json /etc/docker/daemon.json

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
