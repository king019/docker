#!/bin/sh
set -x
source /etc/profile;java -version
cd /app
nohup java -jar /app/LuckyFrameClient.jar >>log.txt &