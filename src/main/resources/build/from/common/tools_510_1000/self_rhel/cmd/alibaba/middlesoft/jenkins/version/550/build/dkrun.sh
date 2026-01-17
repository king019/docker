#!/bin/sh
set -x
source /etc/profile;java -version

cat /root/.docker/config.json >/root/.jenkins/config.json
sh ${WS}/tomcat/bin/shutdown.sh
sh ${WS}/tomcat/bin/startup.sh
sleep 10
tail -f ${WS}/tomcat/logs/*
