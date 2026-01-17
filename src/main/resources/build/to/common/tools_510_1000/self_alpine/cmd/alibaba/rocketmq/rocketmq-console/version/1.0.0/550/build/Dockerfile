FROM king019/alpine:jdk8 as pre

MAINTAINER king019

RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/mirrors/RocketMQ-Externals.git rocketmq-externals
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-externals;git checkout rocketmq-console-1.0.0
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-externals/rocketmq-console;mvn versions:set -DnewVersion=release
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-externals/rocketmq-console;mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/rocketmq-externals/rocketmq-console;cp target/rocketmq-console-ng-release.jar ${WS}/rocketmq-console-ng-release.jar

FROM king019/alpine:jdk8
COPY --from=pre ${WS}/rocketmq-console-ng-release.jar ${WS}/rocketmq-console-ng-release.jar
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
