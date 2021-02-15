FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/
ADD http://download.sonatype.com/nexus/3/nexus-3.29.2-02-unix.tar.gz /opt/soft/nexus-3.29.2-02-unix.tar.gz
#COPY nexus-3.22.0-02-unix.tar.gz /opt/soft/nexus-3.22.0-02-unix.tar.gz

RUN cp /opt/soft/nexus-3.29.2-02-unix.tar.gz /root/tools/nexus-3.29.2-02-unix.tar.gz
RUN cd /root/tools/;tar -xzf nexus-3.29.2-02-unix.tar.gz
RUN cd /root/tools/;mv nexus-3.29.2-02 nexus

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
