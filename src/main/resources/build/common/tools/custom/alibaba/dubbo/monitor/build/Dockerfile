FROM  king019/linux

MAINTAINER king019
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

RUN cd /opt/soft; tar -xzf dubbo-monitor-simple-release-assembly.tar.gz
RUN cd /opt/soft; mv dubbo-monitor-simple-release monitor

EXPOSE 8080


CMD /docker.sh



