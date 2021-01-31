FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft/version
RUN mkdir -p /root/tools
RUN mkdir -p /opt/soft/apollo-adminservice



COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

RUN cp /opt/soft/apollo-adminservice-release-github.zip /opt/soft/apollo-adminservice/apollo-adminservice-release-github.zip
RUN cd /opt/soft/apollo-adminservice;unzip apollo-adminservice-release-github.zip


CMD /docker.sh
