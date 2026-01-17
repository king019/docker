#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
sh shutdown.sh
sh startup.sh -m standalone
tail -f ${WS}/nacos/logs/start.out
