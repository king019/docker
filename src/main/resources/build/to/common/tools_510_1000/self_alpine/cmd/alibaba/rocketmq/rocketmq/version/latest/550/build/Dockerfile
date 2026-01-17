FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/apache/rocketmq.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq;git checkout ${rocketmq_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq;mvn versions:set -DnewVersion=release
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq;mvn -Prelease-all -DskipTests clean install
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq;cp ./distribution/target/rocketmq-release.zip ${WS}/rocketmq-release.zip
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh

FROM  king019/alpine:jdk8


COPY --from=pre ${WS}/rocketmq-release.zip ${WS}/rocketmq-release.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};unzip rocketmq-release.zip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS};mv rocketmq-release rocketmq
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/rocketmq/store
RUN source /etc/profile;chmod 755 /*.sh;mkdir -p ${WS}/rocketmq/conf
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/rocketmq/conf;echo 'storePathRootDir =/app/rocketmq/store' >> broker.properties
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS}/rocketmq/conf;echo 'autoCreateTopicEnable=true' >> broker.properties
RUN source /etc/profile;chmod 755 /*.sh;chmod -R 777 ${WS}/rocketmq

COPY mqbroker_nouse.sh /mqbroker_nouse.sh
COPY mqnamesrv_nouse.sh /mqnamesrv_nouse.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
