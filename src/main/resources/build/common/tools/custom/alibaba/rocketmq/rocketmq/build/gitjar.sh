#!/bin/sh
set -x
source /etc/profile
java -version

cd /opt/soft/version
git clone https://e.coding.net/king019/github/rocketmq.git
cd rocketmq

mvn versions:set -DnewVersion=release
mvn -Prelease-all -DskipTests clean install -T 1

cp ./distribution/target/rocketmq-release.zip /opt/soft/rocketmq-release.zip

mvn clean
rm -fr ~/.m2/repository