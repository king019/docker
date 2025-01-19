#!/bin/sh
set -x
source /etc/profile;java -version
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/apache/rocketmq.git
cd rocketmq
git checkout release-5.3.1
mvn versions:set -DnewVersion=release
mvn -Prelease-all -DskipTests clean install

cp ./distribution/target/rocketmq-release.zip /opt/soft/rocketmq-release.zip
