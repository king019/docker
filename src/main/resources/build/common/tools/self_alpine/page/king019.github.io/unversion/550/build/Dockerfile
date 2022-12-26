FROM  king019/alpine:jdk17

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
