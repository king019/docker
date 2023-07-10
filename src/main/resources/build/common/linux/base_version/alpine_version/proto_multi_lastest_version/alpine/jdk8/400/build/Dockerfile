FROM  king019/alpine:b

MAINTAINER king019

RUN apk add openjdk8

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile

RUN rm -fr /usr/lib/jvm/default-jvm
RUN ln -s /usr/lib/jvm/java-1.8-openjdk /usr/lib/jvm/default-jvm



RUN chmod 755 /*.sh
CMD /docker.sh
