#!/bin/sh
set -x
cd /opt/soft/version
git clone https://gitee.com/king019/zkui.git
cd zkui
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -T 20
find . -name zkui-2.0-SNAPSHOT-jar-with-dependencies.jar|awk '{print "cp " $1  " /opt/soft/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository