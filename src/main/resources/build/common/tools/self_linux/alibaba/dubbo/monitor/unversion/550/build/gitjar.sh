#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git
cd dubbo-admin
git checkout master
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2

cp dubbo-monitor-simple/target/dubbo-monitor-simple-release-assembly.tar.gz /opt/soft/dubbo-monitor-simple-release-assembly.tar.gz

mvn clean
rm -fr ~/.m2/repository