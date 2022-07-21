#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/RocketMQ-Externals.git rocketmq-externals
cd rocketmq-externals
cd rocketmq-console
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp target/rocketmq-console-ng-release.jar /opt/soft/rocketmq-console-ng-release.jar

mvn clean
/mvnclean.sh
