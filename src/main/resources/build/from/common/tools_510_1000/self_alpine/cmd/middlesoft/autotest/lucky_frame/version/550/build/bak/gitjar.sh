#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/seagull1985/LuckyFrameClient.git
cd LuckyFrameClient
git checkout V3.5.2
mvn package -Dmaven.test.skip=true
mv target/LuckyFrameClient.jar ${WS}/LuckyFrameClient.jar