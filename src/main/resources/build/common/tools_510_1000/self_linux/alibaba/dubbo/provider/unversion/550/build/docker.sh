#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
nohup java $JAVA_OPTS -jar /opt/soft/fw_rpc_dubbo_anno_server_nacos-release.jar >>log.txt &
tail -f log.txt
#tail -f /docker.sh
