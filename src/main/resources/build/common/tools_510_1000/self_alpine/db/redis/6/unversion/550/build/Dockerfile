FROM  king019/alpine:jdk11

MAINTAINER king019


RUN apk add redis


COPY dkrun.sh /dkrun.sh

RUN chmod 755 /*.sh
CMD /docker.sh
