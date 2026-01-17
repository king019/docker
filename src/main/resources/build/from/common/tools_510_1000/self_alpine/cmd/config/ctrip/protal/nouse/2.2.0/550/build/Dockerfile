FROM  king019/alpine:jdk8

MAINTAINER king019

RUN mkdir -p ${WS}/apollo-portal


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh



RUN cp ${WS}/apollo-portal-release-github.zip ${WS}/apollo-portal/apollo-portal-release-github.zip
RUN cd ${WS}/apollo-portal;unzip apollo-portal-release-github.zip

CMD /docker.sh
