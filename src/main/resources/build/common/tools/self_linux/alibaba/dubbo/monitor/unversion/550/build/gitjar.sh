#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git
cd dubbo-admin
git checkout master
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp dubbo-monitor-simple/target/dubbo-monitor-simple-release-assembly.tar.gz /opt/soft/dubbo-monitor-simple-release-assembly.tar.gz
cd /opt/soft
tar -xzf dubbo-monitor-simple-release-assembly.tar.gz
cd /opt/soft
mv dubbo-monitor-simple-release monitor
mvn clean
/mvnclean.sh
