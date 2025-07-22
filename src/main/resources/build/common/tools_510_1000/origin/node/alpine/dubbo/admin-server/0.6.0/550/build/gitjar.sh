#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/dubbo-admin.git
dubbo_admin_version=0.6.0
cd dubbo-admin
git checkout ${dubbo_admin_version}






mvn clean package -Dmaven.test.skip=true -pl dubbo-admin-server
cp dubbo-admin-server/target/dubbo-admin-server-${dubbo_admin_version}.jar /opt/soft/dubbo-admin-server.jar
