FROM  king019/centos:res

MAINTAINER king019

RUN dnf -y install  java-21-openjdk-devel

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk21' >> /etc/profile


RUN rm -fr /etc/alternatives/java
RUN ln -s /usr/lib/jvm/java-21-openjdk/bin/java /etc/alternatives/java

RUN chmod 755 /*.sh
CMD /docker.sh
