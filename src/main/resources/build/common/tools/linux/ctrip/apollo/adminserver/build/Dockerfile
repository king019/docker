FROM  king019/linux:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://nginxdown:9500/apollo-adminservice-1.6.2-github.zip /opt/soft/apollo-adminservice-1.6.2-github.zip

RUN cp /opt/soft/apollo-adminservice-1.6.2-github.zip /root/tools/apollo-adminservice-1.6.2-github.zip
RUN cd /root/tools/;unzip apollo-adminservice-1.6.2-github.zip
RUN cd /root/tools/;mv apollo-adminservice-1.6.2-github apollo-adminservice

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
