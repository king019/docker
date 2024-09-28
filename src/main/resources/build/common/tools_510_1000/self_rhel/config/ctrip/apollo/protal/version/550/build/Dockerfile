FROM  king019/apollo:base

MAINTAINER king019

COPY dkrun.sh /dkrun.sh

RUN mkdir -p /opt/soft/apollo-portal
RUN chmod 755 /*.sh

RUN cp /opt/soft/apollo-portal-release-github.zip /opt/soft/apollo-portal/apollo-portal-release-github.zip
RUN cd /opt/soft/apollo-portal;unzip apollo-portal-release-github.zip

CMD /docker.sh
