FROM  king019/centos

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
COPY application.properties /application.properties
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
