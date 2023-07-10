FROM  king019/centos:b

MAINTAINER king019

RUN dnf -y install  java-17-openjdk-devel

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk17' >> /etc/profile

RUN sed -i 's/^export JAVA_HOME/export JAVA_HOME=\/usr\/lib\/jvm\/java-17-openjdk/g'  /usr/share/maven/bin/mvn

RUN rm -fr /etc/alternatives/java
RUN ln -s /usr/lib/jvm/java-17-openjdk/bin/java /etc/alternatives/java


RUN chmod 755 /*.sh
CMD /docker.sh
