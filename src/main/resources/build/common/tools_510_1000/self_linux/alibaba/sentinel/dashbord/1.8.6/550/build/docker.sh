#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
java $JAVA_OPTS -Dserver.port=8080 -Dsentinel.dashboard.removeAppNoMachineMillis=20000 -Dsentinel.dashboard.autoRemoveMachineMillis=20000 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=dashboard -jar sentinel-dashboard.jar
#tail -f /docker.sh
