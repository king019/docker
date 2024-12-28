#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft/rocketmq
sed -i "s/-Xms4g -Xmx4g/ /g" ./bin/runserver.sh
sh bin/mqnamesrv

