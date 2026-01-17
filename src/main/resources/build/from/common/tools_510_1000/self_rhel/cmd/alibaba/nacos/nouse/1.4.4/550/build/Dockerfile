FROM  king019/alpine:jdk8

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
COPY application.properties /application.properties
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
