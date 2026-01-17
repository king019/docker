FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

ENV apollo_version=v2.4.0
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/mirrors/apollo.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd apollo;git checkout ${apollo_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd apollo;mvn versions:set -DnewVersion=release
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd apollo;cd scripts;sh ./build.sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd apollo;cp ./apollo-adminservice/target/apollo-adminservice-release-github.zip ${WS}/apollo-adminservice-release-github.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd apollo;cp ./apollo-configservice/target/apollo-configservice-release-github.zip ${WS}/apollo-configservice-release-github.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};cd apollo;cp ./apollo-portal/target/apollo-portal-release-github.zip ${WS}/apollo-portal-release-github.zip


FROM  king019/alpine:jdk8

ENV apollo_version=v2.4.0
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p WS/apollo-admin
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p WS/apollo-config
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p WS/apollo-portal
COPY --from=pre ${WS}/apollo-adminservice-release-github.zip ${WS}/apollo-admin/apollo-adminservice-release-github.zip
COPY --from=pre ${WS}/apollo-configservice-release-github.zip ${WS}/apollo-config/apollo-configservice-release-github.zip
COPY --from=pre ${WS}/apollo-portal-release-github.zip ${WS}/apollo-portal/apollo-portal-release-github.zip


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

CMD /docker.sh
