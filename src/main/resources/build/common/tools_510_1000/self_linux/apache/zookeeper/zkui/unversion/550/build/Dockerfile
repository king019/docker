FROM  king019/linux:jdk8

MAINTAINER king019


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

COPY config.cfg /opt/soft/config.cfg

CMD /docker.sh
