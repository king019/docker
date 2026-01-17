#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/king019/stressTestPlatform.git
cd stressTestPlatform
mvn package -Dmaven.test.skip=true
mv target/renren-fast.jar ${WS}/renren-fast.jar