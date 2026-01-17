FROM  king019/debian:ex

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo '#jdk11' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
