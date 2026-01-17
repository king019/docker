#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
nohup java $JAVA_OPTS -jar sshm_boot_cloud_admin_server-release.jar >>log.txt &
tail -f log.txt
