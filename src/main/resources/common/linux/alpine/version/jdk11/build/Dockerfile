FROM  king019/alpine:b

MAINTAINER king019

RUN echo 'export JAVA_HOME=/usr/lib/jvm/default-jvm' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
