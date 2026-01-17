FROM  king019/alpine:jdk8

MAINTAINER king019
RUN mkdir -p ${WS}/apollo-adminservice



COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

RUN cp ${WS}/apollo-adminservice-release-github.zip ${WS}/apollo-adminservice/apollo-adminservice-release-github.zip
RUN cd ${WS}/apollo-adminservice;unzip apollo-adminservice-release-github.zip


CMD /docker.sh
