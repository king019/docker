FROM  king019/linux:jdk8

MAINTAINER king019


COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
COPY archiva.xml /archiva.xml
RUN chmod 755 /*.sh
RUN /gitjar.sh


CMD /docker.sh