#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/Sentinel.git
cd Sentinel
mvn clean install -T 5
find . -name sentinel-dashboard.jar|awk '{print "cp " $1  " /opt/soft/sentinel-dashboard.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository