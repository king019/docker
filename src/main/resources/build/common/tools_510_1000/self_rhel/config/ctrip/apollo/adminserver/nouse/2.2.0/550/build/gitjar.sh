#!/bin/sh
set -x
source /etc/profile;java -version
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/apollo.git
cd apollo
git checkout v2.2.0
mvn versions:set -DnewVersion=release
cd scripts
sh ./build.sh

cd ..
cp ./apollo-adminservice/target/apollo-adminservice-release-github.zip /opt/soft/apollo-adminservice-release-github.zip
mvn clean
/mvnclean.sh
