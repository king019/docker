FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/apollo-configservice

ADD https://github.com/ctripcorp/apollo/releases/download/v1.7.1/apollo-configservice-1.7.1-github.zip /opt/soft/apollo-configservice-1.7.1-github.zip

RUN cp /opt/soft/apollo-configservice-1.7.1-github.zip /root/tools/apollo-configservice/apollo-configservice-1.7.1-github.zip
RUN cd /root/tools/apollo-configservice;unzip apollo-configservice-1.7.1-github.zip

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
