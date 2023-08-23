FROM  king019/alpine:res

MAINTAINER king019

RUN apk add maven
RUN apk add openjdk17

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk17' >> /etc/profile

RUN rm -fr /usr/lib/jvm/default-jvm
RUN ln -s /usr/lib/jvm/java-17-openjdk /usr/lib/jvm/default-jvm

RUN chmod 755 /*.sh
CMD /docker.sh
