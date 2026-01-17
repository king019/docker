#!/bin/sh
set -x
source /etc/profile;java -version
java -version
cd ${WS}
git clone https://gitee.com/apache/rocketmq.git
cd rocketmq
git checkout release-5.3.3
mvn versions:set -DnewVersion=release
mvn -Prelease-all -DskipTests clean install

cp ./distribution/target/rocketmq-release.zip ${WS}/rocketmq-release.zip
