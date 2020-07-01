#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java $JAVA_OPTS -Dadmin.registry.address=zookeeper://zookeeper:2181 -Dadmin.config-center=zookeeper://zookeeper:2181 -Dadmin.metadata-report.address=zookeeper://zookeeper:2181 -jar  dubbo-admin-0.2.0.jar &

tail -f /docker.sh
