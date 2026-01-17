FROM  king019/apollo:base

MAINTAINER king019

COPY dkrun.sh /dkrun.sh

RUN mkdir -p ${WS}/apollo-portal
RUN chmod 755 /*.sh

RUN cp ${WS}/apollo-portal-release-github.zip ${WS}/apollo-portal/apollo-portal-release-github.zip
RUN cd ${WS}/apollo-portal;unzip apollo-portal-release-github.zip

CMD /docker.sh
