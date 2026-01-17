#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/king019/rocketmq-dashboard.git
cd rocketmq-dashboard
git checkout rocketmq-dashboard-1.0.0
mvn clean package -Dmaven.test.skip=true
cp target/rocketmq-dashboard-1.0.0.jar ${WS}/rocketmq-dashboard.jar
