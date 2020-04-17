FROM  king019/centos:b

MAINTAINER king019

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



COPY docker.sh /docker.sh
CMD /docker.sh
