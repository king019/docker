FROM  king019/centos:jdk

MAINTAINER king019
RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN chmod 755 /*.sh
CMD /docker.sh
