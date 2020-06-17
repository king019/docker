#!/bin/sh
set -x
source /etc/profile
cd /root/tools
java $JAVA_OPTS -jar  fw_rpc_dubbo_anno_api-1.0-SNAPSHOT.jar >>log.txt

tail -f /docker.sh