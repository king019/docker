#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
#nohup java $JAVA_OPTS -jar /opt/soft/frame_boot_boot_service-release.jar >>log.txt &
nohup /opt/soft/frame_boot_boot_service-release.jar >>log.txt &
tail -f /docker.sh
