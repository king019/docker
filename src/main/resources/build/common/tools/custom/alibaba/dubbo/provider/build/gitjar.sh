#!/bin/sh
set -x

cd /opt/soft/version
git clone https://gitee.com/king019/ali_fw_fw.git
cd ali_fw_fw
cd $(find . -name 'fw_rpc_dubbo_anno_service')
mvn clean install -T 5
find . -name fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository