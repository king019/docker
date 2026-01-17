#!/bin/sh
set -x
source /etc/profile;java -version

nginx

sh ${WS}/tomcat/bin/shutdown.sh
sh ${WS}/tomcat/bin/startup.sh
tail -f /docker.sh
