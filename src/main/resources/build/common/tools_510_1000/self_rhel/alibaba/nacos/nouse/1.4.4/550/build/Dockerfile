FROM  king019/rhel:jdk8

MAINTAINER king019


# RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
# RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
COPY application.properties /application.properties
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
