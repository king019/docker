#!/bin/sh
set -x
source /etc/profile
echo 'notice'> /root/notice.txt
cd /root/soft
nohup java $JAVA_OPTS -jar  /root/tools/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar >>log.txt &

tail -f /docker.sh
