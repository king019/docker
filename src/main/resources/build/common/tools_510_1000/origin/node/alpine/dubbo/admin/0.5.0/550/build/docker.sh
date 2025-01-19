#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft

nohup java $JAVA_OPTS -Dadmin.registry.address=zookeeper://zookeeper:2181 -Dadmin.config-center=zookeeper://zookeeper:2181 -Dadmin.metadata-report.address=zookeeper://zookeeper:2181 -jar dubbo-admin-server.jar &

cd /opt/soft/version/dubbo-admin/dubbo-admin-ui
nohup npm run dev &

tail -f /docker.sh
