#!/bin/sh
set -x


source /etc/profile

cd /root/tools/apollo-portal/config
echo 'dev.meta='$DEV_MATA > apollo-env.properties
cd /root/tools/apollo-portal/scripts
nohup sh startup.sh >log.txt &


tail -f /docker.sh

