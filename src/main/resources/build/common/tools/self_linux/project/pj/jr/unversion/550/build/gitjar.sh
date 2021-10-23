#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/gsls200808/JrebelLicenseServerforJava.git
cd JrebelLicenseServerforJava
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/JrebelBrainsLicenseServerforJava-release.jar"}' | sh
mvn clean
/mvnclean.sh
