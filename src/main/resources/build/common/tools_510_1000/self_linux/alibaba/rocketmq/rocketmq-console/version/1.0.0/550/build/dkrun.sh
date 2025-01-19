#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
nohup java $JAVA_OPTS -jar rocketmq-console-ng-release.jar >>log.txt &
tail -f log.txt
