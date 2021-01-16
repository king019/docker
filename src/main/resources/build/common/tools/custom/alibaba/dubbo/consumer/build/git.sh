#!/bin/sh
set -x
git clone https://github.com/king019/ali_fw_fw.git
cd ali_fw_fw
mvn clean package -DskipTests
cp fw_fw/fw_rpc/fw_rpc_dubbo/fw_rpc_dubbo_anno/fw_rpc_dubbo_anno_api/target/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar
mvn clean