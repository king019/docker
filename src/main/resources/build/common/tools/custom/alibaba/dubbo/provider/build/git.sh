#!/bin/sh
set -x

cd /opt/soft/version
git clone https://github.com/king019/ali_fw_fw.git
cd ali_fw_fw
mvn clean package -DskipTests -Dmaven.javadoc.skip=true
find . -name fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar"}'|sh
mvn clean