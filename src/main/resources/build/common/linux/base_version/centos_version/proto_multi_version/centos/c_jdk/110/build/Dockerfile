FROM king019/centos:res

MAINTAINER king019


RUN dnf -y install  maven


RUN dnf -y install  java-1.8.0-openjdk
RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  java-17-openjdk-devel

RUN chmod -R 777 /*.sh

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk' >> /etc/profile

RUN chmod 755 /*.sh
CMD /docker.sh
