#!/bin/sh
set -x
source /etc/profile
cd /opt/soft
nohup java $JAVA_OPTS -jar  /opt/soft/fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar >>log.txt &

tail -f /docker.sh