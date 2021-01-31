#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/rocketmq.git
cd rocketmq
java -version
mvn versions:set -DnewVersion=release
mvn -Prelease-all -DskipTests clean install -T 5

cp ./distribution/target/rocketmq-release.zip /opt/soft/rocketmq-release.zip

mvn clean
rm -fr ~/.m2/repository