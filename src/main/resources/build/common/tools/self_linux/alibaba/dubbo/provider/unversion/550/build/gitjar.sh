#!/bin/sh
set -x
source /etc/profile;java -version

mkdir -p /root/.m2/repository/com/github/eirslett/node/9.11.1/
cd /root/.m2/repository/com/github/eirslett/node/9.11.1/
wget https://registry.npmmirror.com/-/binary/node/v9.11.1/node-v9.11.1-linux-x64.tar.gz
wget https://registry.npmmirror.com/-/binary/node/v9.11.1/node-v9.11.1-linux-arm64.tar.gz




mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/aliyun/ali_fw_fw.git

cd ali_fw_fw
cd $(find . -name 'fw_rpc_dubbo_anno')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name fw_rpc_dubbo_anno_server_nacos-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/fw_rpc_dubbo_anno_server_nacos-release.jar"}' | sh
mvn clean
/mvnclean.sh
