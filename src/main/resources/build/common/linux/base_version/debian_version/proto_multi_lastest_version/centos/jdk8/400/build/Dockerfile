FROM  king019/debian:b

MAINTAINER king019

RUN dnf -y install  java-1.8.0-openjdk-devel

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile

RUN sed -i 's/^export JAVA_HOME/export JAVA_HOME=\/usr\/lib\/jvm\/java-1.8.0-openjdk/g'  /usr/share/maven/bin/mvn



RUN chmod 755 /*.sh
CMD /docker.sh
