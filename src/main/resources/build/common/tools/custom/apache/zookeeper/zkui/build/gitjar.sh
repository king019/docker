#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/zkui.git
cd zkui
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 5
find . -name zkui-release-jar-with-dependencies.jar|awk '{print "cp " $1  " /opt/soft/zkui-release-jar-with-dependencies.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository