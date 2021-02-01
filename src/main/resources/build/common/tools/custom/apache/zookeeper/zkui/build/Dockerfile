FROM  king019/linux:jdk8

MAINTAINER king019

RUN mkdir -p /opt/soft/version
RUN mkdir -p /root/tools

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

COPY config.cfg /opt/soft/config.cfg

CMD /docker.sh
