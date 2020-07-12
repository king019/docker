FROM  king019/linux:jdk8

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://nginxdown:9500/apollo-portal-1.6.2-github.zip /opt/soft/apollo-portal-1.6.2-github.zip

RUN cp /opt/soft/apollo-portal-1.6.2-github.zip /root/tools/apollo-portal-1.6.2-github.zip
RUN cd /root/tools/;unzip apollo-portal-1.6.2-github.zip
RUN cd /root/tools/;mv apollo-portal-1.6.2-github apollo-portal

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
