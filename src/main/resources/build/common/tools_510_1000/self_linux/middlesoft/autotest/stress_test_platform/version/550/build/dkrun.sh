#!/bin/sh
set -x
source /etc/profile;java -version
cd /app
nohup java -jar /app/renren-fast.jar >>log.txt &