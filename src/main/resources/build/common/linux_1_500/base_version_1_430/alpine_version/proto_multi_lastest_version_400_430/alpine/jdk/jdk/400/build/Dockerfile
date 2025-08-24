FROM  king019/alpine:b

MAINTAINER king019

RUN apk add openjdk21

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-21-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk21' >> /etc/profile

RUN rm -fr /usr/lib/jvm/default-jvm
RUN ln -s /usr/lib/jvm/java-21-openjdk /usr/lib/jvm/default-jvm

RUN chmod 755 /*.sh
CMD /docker.sh
