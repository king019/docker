#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/ali_fw_fw.git

cd ali_fw_fw
cd $(find . -name 'fw_rpc_dubbo_anno')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2
find . -name fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository