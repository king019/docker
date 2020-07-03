#!/bin/bash
set -x

mkdir -p /opt/soft

cd /opt/soft/rocketmq/rocketmq-console
nohup mvn spring-boot:run &

cd /opt/soft/rocketmq/rocketmq-4.4

nohup sh bin/mqnamesrv &
sleep 30
nohup sh bin/mqbroker -n 127.0.0.1:9876 &

tail -f /docker.sh
