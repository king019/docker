#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft/rocketmq
nohup sh bin/mqnamesrv &
tail -f /docker.sh
