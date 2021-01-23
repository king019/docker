#!/bin/sh
set -x
cd /opt/soft/version
git clone https://gitee.com/gsls200808/JrebelLicenseServerforJava.git
cd JrebelLicenseServerforJava
mvn clean install -T 5
find . -name JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository