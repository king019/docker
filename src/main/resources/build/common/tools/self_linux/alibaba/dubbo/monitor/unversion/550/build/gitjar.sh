#!/bin/sh
set -x

source /etc/profile;java -version



mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors_apache/dubbo_1.git dubbo
cd dubbo
git checkout 2.5.x
cd dubbo-simple/dubbo-monitor-simple
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp target/dubbo-monitor-simple-2.5.10-assembly.tar.gz /opt/soft/dubbo-monitor-simple-2.5.10-assembly.tar.gz
mvn clean
cd /opt/soft
tar -xzf dubbo-monitor-simple-2.5.10-assembly.tar.gz
mv dubbo-monitor-simple-2.5.10 monitor
/mvnclean.sh

