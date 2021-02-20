FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft/version
RUN mkdir -p /root/tools
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh


RUN cd /opt/soft; tar -xzf dubbo-monitor-simple-release-assembly.tar.gz
RUN cd /opt/soft; mv dubbo-monitor-simple-release monitor

EXPOSE 8080


RUN /gitjar.sh
CMD /docker.sh



