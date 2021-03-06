#!/bin/sh
set -x
source /etc/profile
cd /root/tools/rocketmq
nohup sh bin/mqnamesrv &
sleep 20
nohup sh bin/mqbroker -n rocketmq:9876  -c conf/broker.properties &
tail -f /docker.sh