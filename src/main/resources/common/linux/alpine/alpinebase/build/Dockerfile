FROM king019/alpine:m

MAINTAINER king019

COPY docker.sh /docker.sh

RUN mkdir -p /root/soft

RUN echo 'export JAVA_HOME=/usr/lib/jvm/default-jvm' >> /etc/profile

RUN chmod 755 /*.sh

CMD /docker.sh
