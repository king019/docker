#!/bin/sh
set -x
source /etc/profile;java -version

nginx

sh /opt/soft/tools/tomcat/bin/shutdown.sh
sh /opt/soft/tools/tomcat/bin/startup.sh
tail -f /docker.sh
