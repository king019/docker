#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
nohup java $JAVA_OPTS -jar rocketmq-dashboard.jar >>log.txt &
tail -f log.txt
