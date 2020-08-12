#!/bin/sh
set -x
source /etc/profile


cat /root/.docker/config.json >   /root/.jenkins/config.json

sh /root/tools/tomcat/bin/shutdown.sh
sh /root/tools/tomcat/bin/startup.sh
tail -f /docker.sh
