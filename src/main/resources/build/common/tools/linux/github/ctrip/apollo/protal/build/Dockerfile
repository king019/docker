FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/apollo-portal
ADD https://github.com/ctripcorp/apollo/releases/download/v1.7.1/apollo-portal-1.7.1-github.zip /opt/soft/apollo-portal-1.7.1-github.zip

RUN cp /opt/soft/apollo-portal-1.7.1-github.zip /root/tools//apollo-portal/apollo-portal-1.7.1-github.zip
RUN cd /root/tools/apollo-portal;unzip apollo-portal-1.7.1-github.zip

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
