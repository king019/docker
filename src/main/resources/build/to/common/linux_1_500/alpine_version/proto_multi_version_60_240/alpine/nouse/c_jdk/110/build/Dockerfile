FROM king019/alpine:res

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven

#RUN apk add go

RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 /*.sh


RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  maven
RUN source /etc/profile;chmod 755 /*.sh;apk add --allow-untrusted  openjdk21
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /usr/lib/jvm/default-jvm
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-21-openjdk /usr/lib/jvm/default-jvm

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh


CMD /docker.sh
