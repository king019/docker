#!/bin/bin
set -x
cd /root/soft/Sentinel/sentinel-dashboard
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar target/sentinel-dashboard.jar
tail -f /docker.sh
