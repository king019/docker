FROM  king019/alpine:b

MAINTAINER king019


COPY settings.xml /root/.m2/settings.xml
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
