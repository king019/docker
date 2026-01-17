FROM  king019/debian:b

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  openjdk-17-jdk

RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo '#jdk17' >> /etc/profile

#RUN sed -i 's/^export JAVA_HOME/export JAVA_HOME=\/usr\/lib\/jvm\/java-17-openjdk/g'  /usr/share/maven/bin/mvn


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
