FROM  king019/rhel:jdk8

MAINTAINER king019

RUN mkdir -p /opt/soft/apollo-portal


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh



RUN cp /opt/soft/apollo-portal-release-github.zip /opt/soft/apollo-portal/apollo-portal-release-github.zip
RUN cd /opt/soft/apollo-portal;unzip apollo-portal-release-github.zip

CMD /docker.sh
