#!/bin/sh
set -x
source /etc/profile
echo 'notice'> /root/notice.txt
cd /root/tools
nohup java -jar sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar &
tail -f /docker.sh
