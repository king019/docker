#!/bin/sh
set -x
source /etc/profile
echo 'notice'> /opt/soft/notice.txt
cd /opt/soft
nohup java $JAVA_OPTS -jar  /opt/soft/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar >>log.txt &

tail -f /docker.sh
