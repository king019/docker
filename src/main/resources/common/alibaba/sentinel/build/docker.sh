#!/bin/sh
set -x
source /etc/profile
cd /root/tools
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar target/sentinel-dashboard.jar
tail -f /docker.sh
