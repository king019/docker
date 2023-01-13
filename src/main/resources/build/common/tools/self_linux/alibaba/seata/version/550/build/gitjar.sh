#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/Seata.git seata
cd seata
git checkout v1.6.1
sed -i 's/<module>ext\/apm-seata-skywalking-plugin<\/module>//g' pom.xml
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Denforcer.skip=true -Dshade.skip=true
#find . -name seata-server-1.6.1 | awk '{print "cp " $1  " /opt/soft/seata-server-1.6.1"}' | sh
mvn clean
/mvnclean.sh
