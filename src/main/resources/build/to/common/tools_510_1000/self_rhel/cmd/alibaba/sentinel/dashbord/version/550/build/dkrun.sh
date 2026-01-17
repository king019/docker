#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
java $JAVA_OPTS -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=dashboard -jar sentinel-dashboard.jar
