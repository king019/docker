#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}/rocketmq
sed -i "s/-Xms4g -Xmx4g/ /g" ./bin/runserver.sh
sh bin/mqnamesrv

