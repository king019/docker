#!/bin/sh
set -x
source /etc/profile
cd /root/tools
java $JAVA_OPTS -jar rocketmq-console-ng.jar
tail -f /docker.sh
