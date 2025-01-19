FROM king019/debian:res

MAINTAINER king019


#apt-cache search jdk
#RUN apt-get -y install  openjdk-8-jdk
#RUN apt-get -y install  openjdk-11-jdk
RUN apt-get -y install  openjdk-17-jdk

COPY config/jdk.sh /jdk.sh
RUN chmod -R 777 /*.sh
RUN /jdk.sh
RUN ln -s /usr/lib/jvm/openjdk-8   /usr/lib/jvm/java-1.8.0-openjdk
RUN ln -s /usr/lib/jvm/openjdk-11   /usr/lib/jvm/java-11-openjdk
RUN ln -s /usr/lib/jvm/openjdk-17   /usr/lib/jvm/java-17-openjdk


RUN apt-get -y install  maven
RUN cp /usr/share/maven/bin/mvn /usr/share/maven/bin/mvn.bak
RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk' >> /etc/profile

RUN chmod 755 /*.sh
CMD /docker.sh
