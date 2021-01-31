FROM  king019/alpine:b

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
