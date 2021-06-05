#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/nacos.git
cd nacos
git checkout 1.4.1
cd consistency
sed -i 's/<pluginId>grpc-java<\/pluginId>/<pluginId>grpc-java<\/pluginId><skip>true<\/skip>/' pom.xml
protoc --java_out src/main/java/ src/main/proto/consistency.proto
protoc --java_out src/main/java/ src/main/proto/Data.proto

cd ..

mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  -T 2

find . -name nacos-server-1.4.1.zip | awk '{print "cp " $1  " /opt/soft/nacos-server-1.4.1.zip"}' | sh
mvn clean
rm -fr ~/.m2/repository

cd /opt/soft
unzip nacos-server-1.4.1.zip