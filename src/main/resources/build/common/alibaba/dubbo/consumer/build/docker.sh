#!/bin/sh
set -x
source /etc/profile
cd /root/soft
nohup java $JAVA_OPTS -jar  /root/tools/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar >>log.txt &

tail -f /docker.sh