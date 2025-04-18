#!/bin/sh
set -x
javah -version
source /etc/profile;java -version

mkdir -p /opt/soft/arthas
arthas_version=4.0.5
mvn dependency:get -Dtransitive=false -DgroupId=com.taobao.arthas -DartifactId=arthas-packaging -Dversion=${arthas_version} -Dclassifier=bin -Dpackaging=zip
cp /root/.m2/repository/com/taobao/arthas/arthas-packaging/${arthas_version}/arthas-packaging-${arthas_version}-bin.zip /opt/soft/arthas
cd /opt/soft/arthas
unzip arthas-packaging-${arthas_version}-bin.zip

#mvn clean
#/mvnclean.sh
