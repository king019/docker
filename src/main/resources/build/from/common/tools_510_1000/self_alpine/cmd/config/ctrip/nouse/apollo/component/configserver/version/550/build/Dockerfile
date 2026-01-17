FROM  king019/apollo:base

MAINTAINER king019

RUN mkdir -p ${WS}/apollo-configservice


COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh


RUN cp ${WS}/apollo-configservice-release-github.zip ${WS}/apollo-configservice/apollo-configservice-release-github.zip
RUN cd ${WS}/apollo-configservice;unzip apollo-configservice-release-github.zip

CMD /docker.sh
