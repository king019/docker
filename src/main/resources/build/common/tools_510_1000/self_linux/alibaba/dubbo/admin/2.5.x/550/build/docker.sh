#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft

cd /opt/soft/tools/tomcat/bin

sh shutdown.sh
sh startup.sh

tail -f /docker.sh
