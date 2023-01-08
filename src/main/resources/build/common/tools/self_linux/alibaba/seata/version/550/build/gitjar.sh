#!/bin/sh
set -x
javah -version
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/Seata.git seata
cd seata
git checkout v1.6.1
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name arthas-boot-jar-with-dependencies.jar | awk '{print "cp " $1  " /opt/soft/arthas-boot.jar"}' | sh
mvn clean
/mvnclean.sh
