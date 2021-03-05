#!/bin/sh
set -x
source /etc/profile
java -version

cd /opt/soft/version
git clone https://e.coding.net/king019/github/rocketmq.git
cd rocketmq
git checkout release-4.8.0
mvn versions:set -DnewVersion=release
mvn -Prelease-all -DskipTests clean install -T 2

cp ./distribution/target/rocketmq-release.zip /opt/soft/rocketmq-release.zip

mvn clean
rm -fr ~/.m2/repository