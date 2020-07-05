#!/bin/sh
set -x
source /etc/profile

sh /root/tools/tomcat/bin/shutdown.sh
sh /root/tools/tomcat/bin/startup.sh
tail -f /docker.sh
