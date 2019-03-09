#!/bin/bash
set -x

mkdir -p /opt/soft

cd /opt/soft

cd /opt/soft/rocketmq/rocketmq-4.4

nohup sh bin/mqnamesrv &
sleep 60
nohup sh bin/mqbroker -n 127.0.0.1:9876 &
sleep 60
cd /opt/soft/rocketmq/rocketmq-console
mvn spring-boot:run
tail -f /docker.sh
