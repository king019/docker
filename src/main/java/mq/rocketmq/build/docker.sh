#!/bin/bash
set -x

mkdir -p /opt/soft

cd /opt/soft

cd /opt/soft/rocketmq/rocketmq-4.4

nohup sh bin/mqnamesrv &
sleep 5
nohup sh bin/mqbroker -n 127.0.0.1:9876 &
sleep 5
cd /opt/soft/rocketmq/rocketmq-console
nohup mvn spring-boot:run &
tail -f /docker.sh
