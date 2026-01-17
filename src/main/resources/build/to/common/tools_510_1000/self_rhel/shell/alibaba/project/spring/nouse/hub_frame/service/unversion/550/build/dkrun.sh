#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
nohup java $JAVA_OPTS -jar ${WS}/frame_boot_boot_service-release.jar >>log.txt &
tail -f log.txt
