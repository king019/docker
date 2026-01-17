#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/mirrors/RocketMQ-Externals.git rocketmq-externals
cd rocketmq-externals
git checkout rocketmq-console-1.0.0
cd rocketmq-console
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp target/rocketmq-console-ng-release.jar ${WS}/rocketmq-console-ng-release.jar
