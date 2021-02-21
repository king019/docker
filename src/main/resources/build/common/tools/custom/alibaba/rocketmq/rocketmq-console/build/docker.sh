#!/bin/sh
set -x
source /etc/profile
cd /opt/soft
nohup java $JAVA_OPTS -jar rocketmq-console-ng.jar >>log.txt &
tail -f /docker.sh
