#!/bin/sh
set -x
source /etc/profile

sh /opt/soft/tomcat/bin/shutdown.sh
sh /opt/soft/tomcat/bin/startup.sh
tail -f /docker.sh
