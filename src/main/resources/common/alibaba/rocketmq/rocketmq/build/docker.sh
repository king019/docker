#!/bin/sh
set -x
source /etc/profile
cd /root/tools/rocketmq
nohup sh bin/mqnamesrv &
nohup sh bin/mqbroker -n 127.0.0.1:9876 &
tail -f /docker.sh