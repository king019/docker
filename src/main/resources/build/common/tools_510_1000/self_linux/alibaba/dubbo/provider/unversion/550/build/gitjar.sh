#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/ali_fw_fw.git

cd ali_fw_fw
cd $(find . -name 'fw_rpc_dubbo_anno')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name fw_rpc_dubbo_anno_server_nacos-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_server_nacos-release.jar"}' | sh
mvn clean
/mvnclean.sh
