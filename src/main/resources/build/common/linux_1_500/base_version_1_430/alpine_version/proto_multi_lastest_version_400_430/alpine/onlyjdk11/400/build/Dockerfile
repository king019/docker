FROM  king019/alpine:res

MAINTAINER king019

RUN apk add openjdk11

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk11' >> /etc/profile


RUN rm -fr /usr/lib/jvm/default-jvm
RUN ln -s /usr/lib/jvm/java-11-openjdk /usr/lib/jvm/default-jvm

RUN chmod 755 /*.sh
CMD /docker.sh
