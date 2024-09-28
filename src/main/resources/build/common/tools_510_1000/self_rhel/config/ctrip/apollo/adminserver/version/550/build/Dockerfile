FROM  king019/apollo:base

MAINTAINER king019
RUN mkdir -p /opt/soft/apollo-adminservice



COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh

RUN cp /opt/soft/apollo-adminservice-release-github.zip /opt/soft/apollo-adminservice/apollo-adminservice-release-github.zip
RUN cd /opt/soft/apollo-adminservice;unzip apollo-adminservice-release-github.zip


CMD /docker.sh
