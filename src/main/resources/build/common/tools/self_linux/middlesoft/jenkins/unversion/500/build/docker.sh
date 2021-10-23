#!/bin/sh
set -x
source /etc/profile

cat /root/.docker/config.json >/root/.jenkins/config.json
sh /opt/soft/tools/tomcat/bin/shutdown.sh
sh /opt/soft/tools/tomcat/bin/startup.sh
tail -f /docker.sh
