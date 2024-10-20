#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
mkdir -p /app

git clone https://gitee.com/seagull1985/LuckyFrameClient.git
cd LuckyFrameClient
git checkout V3.5.2
mvn package -Dmaven.test.skip=true
mv target/LuckyFrameClient.jar /app/LuckyFrameClient.jar