#!/bin/sh
set -x
source /etc/profile;java -version

cat /root/.docker/config.json >/root/.jenkins/config.json
sh /opt/soft/tool/tomcat/bin/shutdown.sh
sh /opt/soft/tool/tomcat/bin/startup.sh
tail -f /docker.sh
