#!/bin/sh
set -x
source /etc/profile;java -version

cat /root/.docker/config.json >/root/.jenkins/config.json
sh /opt/soft/tools/tomcat/bin/shutdown.sh
sh /opt/soft/tools/tomcat/bin/startup.sh
sleep 10
tail -f /opt/soft/tools/tomcat/logs/*
#tail -f /docker.sh
