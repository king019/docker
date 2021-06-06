#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git
cd dubbo-admin
git checkout 0.2.0
cd dubbo-admin-ui

sed -i '38,80d' pom.xml
npm install
npm run build
cd ..
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2

cp dubbo-admin-distribution/target/dubbo-admin-release.jar /opt/soft/dubbo-admin-release.jar
mvn clean
rm -fr ~/.m2/repository

#cd dubbo-admin
#git checkout master
#mvn versions:set -DnewVersion=release
#mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2
#
#cp dubbo-admin/target/dubbo-admin-release.jar /opt/soft/dubbo-admin-release.jar
#
#mvn clean
#rm -fr ~/.m2/repository
