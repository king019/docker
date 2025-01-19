#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
mkdir -p /app

git clone https://gitee.com/king019/stressTestPlatform.git
cd stressTestPlatform
mvn package -Dmaven.test.skip=true
mv target/renren-fast.jar /app/renren-fast.jar