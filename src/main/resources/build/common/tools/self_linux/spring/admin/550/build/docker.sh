#!/bin/sh
set -x
source /etc/profile
cd /opt/soft
nohup java $JAVA_OPTS -jar sshm_boot_cloud_admin_server-release.jar &

tail -f /docker.sh
