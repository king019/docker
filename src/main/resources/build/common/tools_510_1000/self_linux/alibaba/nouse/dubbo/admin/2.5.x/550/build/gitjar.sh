#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/apache/dubbo.git dubbo

cd dubbo
git checkout 2.5.x
cd dubbo-admin

mvn clean package -Dmaven.test.skip=true
cp target/dubbo-admin-2.5.10.war /opt/soft/tool/tomcat/webapps/ROOT.war
