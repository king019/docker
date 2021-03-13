#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git
cd dubbo-admin
git checkout master
cd dubbo-admin
mvn versions:set -DnewVersion=release
cd ..
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2


cp dubbo-admin/target/dubbo-admin-release.jar /opt/soft/dubbo-admin-release.jar

mvn clean
rm -fr ~/.m2/repository