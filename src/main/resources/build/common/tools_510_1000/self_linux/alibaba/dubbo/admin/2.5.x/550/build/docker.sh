#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft

cd /opt/soft/tool/tomcat/bin

sh shutdown.sh
sh startup.sh
sleep 10
tail -f /opt/soft/tool/tomcat/logs/*
#tail -f /docker.sh
