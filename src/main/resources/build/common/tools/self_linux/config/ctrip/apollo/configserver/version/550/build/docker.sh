#!/bin/sh
set -x

source /etc/profile
cd /opt/soft/apollo-configservice/scripts
nohup sh startup.sh >log.txt &

tail -f /docker.sh
