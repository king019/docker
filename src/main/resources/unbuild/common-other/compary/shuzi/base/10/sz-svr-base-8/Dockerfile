FROM king019/alpine:jdk8
MAINTAINER king019

COPY docker.sh /docker.sh
RUN chmod -R 777 /*.sh
RUN sh /trans.sh
CMD /docker.sh