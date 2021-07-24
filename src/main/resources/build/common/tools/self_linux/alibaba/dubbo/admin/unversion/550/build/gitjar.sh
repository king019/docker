#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git

cd dubbo-admin
git checkout master
cd dubbo-admin
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
cp target/dubbo-admin-0.0.1-SNAPSHOT.jar /opt/soft/dubbo-admin-release.jar

mvn clean
rm -fr ~/.m2/repository

#cd dubbo-admin
#mvn versions:set -DnewVersion=release
#
#sed -i "s/@SPI(\"zookeeper\")/@SPI(\"nacos\")/g" dubbo-admin-server/src/main/java/org/apache/dubbo/admin/registry/config/GovernanceConfiguration.java
#sed -i "s/@SPI(\"zookeeper\")/@SPI(\"nacos\")/g" dubbo-admin-server/src/main/java/org/apache/dubbo/admin/registry/metadata/MetaDataCollector.java
#
#cd dubbo-admin-ui
#
#sed -i '38,80d' pom.xml
#npm install
#npm run build
#cd ..
#mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2
#
#cp dubbo-admin-distribution/target/dubbo-admin-release.jar /opt/soft/dubbo-admin-release.jar
#mvn clean
#rm -fr ~/.m2/repository
