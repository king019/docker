#!/bin/sh
set -x
cd /opt/soft/version
git clone https://gitee.com/king019/Sentinel.git
cd Sentinel
cd $(find . -name 'sentinel-dashboard')
mvn clean install -T 5
find . -name sentinel-dashboard.jar|awk '{print "cp " $1  " /opt/soft/sentinel-dashboard.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository