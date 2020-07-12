#!/bin/sh
set -x


source /etc/profile
cd /root/tools/apollo-configservice/scripts
nohup sh startup.sh >log.txt &


tail -f /docker.sh
