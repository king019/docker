#!/bin/sh
set -x
source /etc/profile
cd /opt/soft
nohup java $JAVA_OPTS -jar sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar &

tail -f /docker.sh
