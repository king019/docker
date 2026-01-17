FROM king019/rhel:res

MAINTAINER king019


RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;cp /usr/share/maven/bin/mvn /usr/share/maven/bin/mvn.bak


RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  maven
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install  java-21-openjdk-devel
RUN source /etc/profile;chmod 755 /*.sh;echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN source /etc/profile;chmod 755 /*.sh;rm -fr /etc/alternatives/java
RUN source /etc/profile;chmod 755 /*.sh;ln -s /usr/lib/jvm/java-21-openjdk/bin/java /etc/alternatives/java

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
