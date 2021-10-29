#!/bin/sh
set -x
source /etc/profile
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/rocketmq.git
cd rocketmq
git checkout release-4.9.2
mvn versions:set -DnewVersion=release
mvn -Prelease-all -DskipTests clean install

cp ./distribution/target/rocketmq-release.zip /opt/soft/rocketmq-release.zip

mvn clean
/mvnclean.sh
