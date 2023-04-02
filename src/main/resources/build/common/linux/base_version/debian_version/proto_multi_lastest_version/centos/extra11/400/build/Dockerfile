FROM  king019/debian:ex

MAINTAINER king019

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk11' >> /etc/profile
RUN chmod 755 /*.sh
CMD /docker.sh
