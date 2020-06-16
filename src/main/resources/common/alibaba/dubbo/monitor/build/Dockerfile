FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://aaaaaa/dubbo-monitor-simple-2.0.0-assembly.tar.gz /opt/soft/dubbo-monitor-simple-2.0.0-assembly.tar.gz
RUN mkdir -p /root/tools
RUN cp /opt/soft/dubbo-monitor-simple-2.0.0-assembly.tar.gz /root/tools/dubbo-monitor-simple-2.0.0-assembly.tar.gz
RUN cd /root/tools; tar -xzf dubbo-monitor-simple-2.0.0-assembly.tar.gz
RUN cd /root/tools; mv dubbo-monitor-simple-2.0.0 monitor

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
