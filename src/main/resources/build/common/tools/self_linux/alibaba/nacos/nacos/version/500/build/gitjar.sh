#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/nacos.git
cd nacos
git checkout 2.0.0
cd consistency
sed -i 's/<pluginId>grpc-java<\/pluginId>/<pluginId>grpc-java<\/pluginId><skip>true<\/skip>/' pom.xml
protoc --java_out src/main/java/ src/main/proto/consistency.proto
protoc --java_out src/main/java/ src/main/proto/Data.proto

cd ..

mvn -Prelease-nacos -Dmaven.test.skip=true clean install

find . -name nacos-server-2.0.0.zip | awk '{print "cp " $1  " /opt/soft/nacos-server-2.0.0.zip"}' | sh
mvn clean
/mvnclean.sh

cd /opt/soft
unzip nacos-server-2.0.0.zip
cat /application.properties > /opt/soft/nacos/conf/application.properties
