FROM  king019/rhel:jdk8

MAINTAINER king019

RUN mkdir -p /opt/soft/apollo-configservice


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


RUN cp /opt/soft/apollo-configservice-release-github.zip /opt/soft/apollo-configservice/apollo-configservice-release-github.zip
RUN cd /opt/soft/apollo-configservice;unzip apollo-configservice-release-github.zip

CMD /docker.sh
