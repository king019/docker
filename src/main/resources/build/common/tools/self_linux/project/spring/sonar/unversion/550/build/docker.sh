#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
nohup java $JAVA_OPTS -jar fw_project_sonar-1.0-SNAPSHOT.jar &

tail -f /docker.sh
