#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/zkui.git
cd zkui
mvn clean install -T 5
find . -name zkui-2.0-SNAPSHOT-jar-with-dependencies.jar|awk '{print "cp " $1  " /opt/soft/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository