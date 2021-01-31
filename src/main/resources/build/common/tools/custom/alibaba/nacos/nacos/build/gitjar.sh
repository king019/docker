#!/bin/sh
set -x
source /etc/profile
java -version

cd /opt/soft/version
git clone https://e.coding.net/king019/github/nacos.git
cd nacos
mvn versions:set -DnewVersion=release
mvn -Prelease-nacos -DskipTests clean install -U -T 5

cd $(find . -name 'fw_rpc_dubbo_anno_api')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 5
find . -name fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository