#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}/rocketmq
sed -i "s/-Xms8g -Xmx8g/ /g" ./bin/runbroker.sh
sleep 20
sh bin/mqbroker -n rocketmqsrv:9876 -c conf/broker.properties
