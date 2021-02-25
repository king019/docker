FROM  king019/linux:jdk8

MAINTAINER king019

RUN mkdir -p /opt/soft/version
RUN mkdir -p /root/tools

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
RUN cd /root/tools/;unzip nexus-base-template-3.7.0-04.zip
RUN cd /root/tools/;mv nexus-base-template-3.7.0-04 nexus

CMD /docker.sh