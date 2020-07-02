#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java $JAVA_OPTS -jar rocketmq-console-ng.jar >>log.txt &
tail -f /docker.sh
