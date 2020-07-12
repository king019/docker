FROM  king019/linux:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/apollo-configservice

ADD http://nginxdown:9500/apollo-configservice-1.6.2-github.zip /opt/soft/apollo-configservice-1.6.2-github.zip

RUN cp /opt/soft/apollo-configservice-1.6.2-github.zip /root/tools/apollo-configservice-1.6.2-github.zip
RUN cd /root/tools/apollo-configservice;unzip apollo-configservice-1.6.2-github.zip

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
