#!/bin/sh
set -x
source /etc/profile

sh /root/soft/tomcat/bin/shutdown.sh
sh /root/soft/tomcat/bin/startup.sh
tail -f /docker.sh
