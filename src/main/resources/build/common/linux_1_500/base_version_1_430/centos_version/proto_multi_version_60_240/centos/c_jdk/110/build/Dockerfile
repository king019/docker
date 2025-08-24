FROM king019/centos:res

MAINTAINER king019


RUN dnf -y install  maven
RUN cp /usr/share/maven/bin/mvn /usr/share/maven/bin/mvn.bak


RUN dnf -y install  java-21-openjdk-devel
#RUN dnf -y install go

RUN chmod -R 777 /*.sh

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk' >> /etc/profile

RUN chmod 755 /*.sh
CMD /docker.sh
