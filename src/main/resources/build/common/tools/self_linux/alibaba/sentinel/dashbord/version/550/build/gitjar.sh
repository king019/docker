#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/Sentinel.git
cd Sentinel/sentinel-dashboard
git checkout 1.8.1
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name sentinel-dashboard.jar | awk '{print "cp " $1  " /opt/soft/sentinel-dashboard.jar"}' | sh
ls /opt/soft
mvn clean
rm -fr ~/.m2/repository
