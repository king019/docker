#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/rocketmq-dashboard.git
cd rocketmq-dashboard
git checkout rocketmq-dashboard-1.0.0
mvn clean package -Dmaven.test.skip=true
cp target/rocketmq-dashboard-1.0.0.jar /opt/soft/rocketmq-dashboard.jar
