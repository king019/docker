#!/bin/sh
set -x


source /etc/profile
cd /opt/soft/apollo-adminservice/scripts
nohup sh startup.sh >log.txt &


tail -f /docker.sh
