#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git
cd dubbo-admin
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2


cd dubbo-admin-distribution/target; java -jar dubbo-admin-release.jar

cd $(find . -name 'fw_rpc_dubbo_anno_api')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2
find . -name fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository