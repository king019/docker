#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java $JAVA_OPTS -jar  fw_rpc_dubbo_anno_service-1.0-SNAPSHOT.jar &

tail -f /docker.sh