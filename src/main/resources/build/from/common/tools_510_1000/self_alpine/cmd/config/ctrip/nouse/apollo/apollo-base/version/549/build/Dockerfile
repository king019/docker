FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

FROM  king019/alpine:jdk8
COPY --from=pre ${WS}/apollo-adminservice-release-github.zip ${WS}/apollo-adminservice-release-github.zip
COPY --from=pre ${WS}/apollo-configservice-release-github.zip ${WS}/apollo-configservice-release-github.zip
COPY --from=pre ${WS}/apollo-portal-release-github.zip ${WS}/apollo-portal-release-github.zip



CMD /docker.sh
