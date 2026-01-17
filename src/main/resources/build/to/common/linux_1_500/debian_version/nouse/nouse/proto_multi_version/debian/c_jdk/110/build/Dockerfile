FROM king019/debian:res

MAINTAINER king019


#apt-cache search jdk
#RUN apt-get -y install  openjdk-8-jdk
#RUN apt-get -y install  openjdk-11-jdk
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  openjdk-17-jdk

COPY config/jdk.sh /jdk.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/jdk.sh
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/openjdk-8   /usr/lib/jvm/java-1.8.0-openjdk
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/openjdk-11   /usr/lib/jvm/java-11-openjdk
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/openjdk-17   /usr/lib/jvm/java-17-openjdk


RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;cp /usr/share/maven/bin/mvn /usr/share/maven/bin/mvn.bak
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo '#jdk' >> /etc/profile

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
