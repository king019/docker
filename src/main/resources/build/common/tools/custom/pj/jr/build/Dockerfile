FROM  king019/linux:jdk11

MAINTAINER king019
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /opt/soft/version

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh
