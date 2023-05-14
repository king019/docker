#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/Nacos.git nacos
cd nacos
git checkout 2.2.2

cd console
sed -i 's/<artifactId>spring-boot-maven-plugin<\/artifactId>/<artifactId>spring-boot-maven-plugin<\/artifactId><version>2.6.3<\/version>/' pom.xml

cd ..
mvn -Prelease-nacos -Dmaven.test.skip=true clean install

find . -name nacos-server-2.2.2.zip | awk '{print "cp " $1  " /opt/soft/nacos-server-2.2.2.zip"}' | sh
mvn clean
/mvnclean.sh

cd /opt/soft
unzip nacos-server-2.2.2.zip
cat /application.properties > /opt/soft/nacos/conf/application.properties
