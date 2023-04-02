FROM king019/debian:res

MAINTAINER king019


RUN dnf -y install  maven

#apt-cache search jdk

#RUN apt-get -y install  openjdk-8-jdk
RUN apt-get -y install  openjdk-11-jdk
RUN apt-get -y install  openjdk-17-jdk

RUN chmod -R 777 /*.sh

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk' >> /etc/profile

RUN chmod 755 /*.sh
CMD /docker.sh
