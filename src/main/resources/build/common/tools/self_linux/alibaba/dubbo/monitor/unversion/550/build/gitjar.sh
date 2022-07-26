#!/bin/sh
set -x

source /etc/profile;java -version

mkdir -p /root/.m2/repository/com/github/eirslett/node/9.11.1/
cd /root/.m2/repository/com/github/eirslett/node/9.11.1/
wget https://mirrors.aliyun.com/nodejs-release/v9.11.1/node-v9.11.1-linux-x64.tar.gz


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git
cd dubbo-admin
git checkout master
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp dubbo-monitor-simple/target/dubbo-monitor-simple-release-assembly.tar.gz /opt/soft/dubbo-monitor-simple-release-assembly.tar.gz
mvn clean
cd /opt/soft
tar -xzf dubbo-monitor-simple-release-assembly.tar.gz
mv dubbo-monitor-simple-release monitor
/mvnclean.sh

