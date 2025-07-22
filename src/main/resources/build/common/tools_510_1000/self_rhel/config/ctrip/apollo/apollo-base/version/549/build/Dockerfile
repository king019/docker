FROM  king019/rhel:jdk8 as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh

FROM  king019/rhel:jdk8
COPY --from=pre /opt/soft/apollo-adminservice-release-github.zip /opt/soft/apollo-adminservice-release-github.zip
COPY --from=pre /opt/soft/apollo-configservice-release-github.zip /opt/soft/apollo-configservice-release-github.zip
COPY --from=pre /opt/soft/apollo-portal-release-github.zip /opt/soft/apollo-portal-release-github.zip



CMD /docker.sh
