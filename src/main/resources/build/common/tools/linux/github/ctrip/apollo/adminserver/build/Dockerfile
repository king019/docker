FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft/
RUN mkdir -p /root/tools/apollo-adminservice
ADD http://nginxdown:9500/apollo-adminservice-1.6.2-github.zip /opt/soft/apollo-adminservice-1.6.2-github.zip

RUN cp /opt/soft/apollo-adminservice-1.6.2-github.zip /root/tools/apollo-adminservice/apollo-adminservice-1.6.2-github.zip
RUN cd /root/tools/apollo-adminservice;unzip apollo-adminservice-1.6.2-github.zip

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
