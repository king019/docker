FROM  king019/alpine:jdk8

MAINTAINER king019

RUN mkdir -p ${WS}/apollo-configservice


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


RUN cp ${WS}/apollo-configservice-release-github.zip ${WS}/apollo-configservice/apollo-configservice-release-github.zip
RUN cd ${WS}/apollo-configservice;unzip apollo-configservice-release-github.zip

CMD /docker.sh
