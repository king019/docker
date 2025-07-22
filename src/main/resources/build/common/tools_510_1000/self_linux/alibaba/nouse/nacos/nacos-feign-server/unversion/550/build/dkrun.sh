#!/bin/sh
set -x
source /etc/profile;java -version
echo 'notice' >/opt/soft/notice.txt
cd /opt/soft
nohup java $JAVA_OPTS -jar /opt/soft/sshm_cloud_feign_nacos_server-release.jar >>log.txt &
tail -f log.txt
