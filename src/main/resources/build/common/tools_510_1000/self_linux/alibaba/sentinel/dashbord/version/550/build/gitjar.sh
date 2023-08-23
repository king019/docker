#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/Sentinel.git sentinel
cd sentinel/sentinel-dashboard
git checkout 2.0.0-alpha
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name sentinel-dashboard.jar | awk '{print "cp " $1  " /opt/soft/sentinel-dashboard.jar"}' | sh
ls /opt/soft
mvn clean
/mvnclean.sh