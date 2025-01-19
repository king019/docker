#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitcode.com/gh_mirrors/na/nacos.git
#git clone https://gitee.com/mirrors/Nacos.git nacos
#https://gitcode.com/gh_mirrors/na/nacos.git
#https://hub.nuaa.cf/alibaba/nacos.git



nacos_version=2.4.3

cd nacos
git checkout ${nacos_version}

cd console
sed -i 's/<artifactId>spring-boot-maven-plugin<\/artifactId>/<artifactId>spring-boot-maven-plugin<\/artifactId><version>2.6.3<\/version>/' pom.xml

cd ..
mvn -Prelease-nacos -Dmaven.test.skip=true clean install

find . -name nacos-server-${nacos_version}.zip | awk -v nacos_version=${nacos_version}  '{print "cp " $1  " /opt/soft/nacos-server-"nacos_version".zip"}' | sh
mvn clean
/mvnclean.sh

cd /opt/soft
unzip nacos-server-${nacos_version}.zip
cat /application.properties > /opt/soft/nacos/conf/application.properties
