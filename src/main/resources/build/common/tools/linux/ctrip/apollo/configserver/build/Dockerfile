FROM  king019/linux:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://nginxdown:9500/apollo-configservice-1.6.2-github.zip /opt/soft/apollo-configservice-1.6.2-github.zip

RUN cp /opt/soft/apollo-configservice-1.6.2-github.zip /root/tools/apollo-configservice-1.6.2-github.zip
RUN cd /root/tools/;unzip apollo-configservice-1.6.2-github.zip
RUN cd /root/tools/;mv apollo-configservice-1.6.2-github apollo-configservice

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
