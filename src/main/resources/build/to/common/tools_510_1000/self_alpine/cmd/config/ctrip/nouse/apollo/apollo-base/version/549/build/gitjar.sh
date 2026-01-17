#!/bin/sh
set -x
source /etc/profile;java -version
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/apollo.git
cd apollo
git checkout v2.4.0
mvn versions:set -DnewVersion=release
cd scripts
sh ./build.sh

cd ..
cp ./apollo-adminservice/target/apollo-adminservice-release-github.zip /opt/soft/apollo-adminservice-release-github.zip
cp ./apollo-configservice/target/apollo-configservice-release-github.zip /opt/soft/apollo-configservice-release-github.zip
cp ./apollo-portal/target/apollo-portal-release-github.zip /opt/soft/apollo-portal-release-github.zip
