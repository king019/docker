#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/king019/JrebelLicenseServerforJava.git
cd JrebelLicenseServerforJava
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/JrebelBrainsLicenseServerforJava-release.jar"}' | sh
