#!/bin/sh
set -x
source /etc/profile
cd /opt/soft
nohup java $JAVA_OPTS -Ddubbo.registry.address=nacos://nacos:8848 -Dadmin.config-center=nacos://nacos:8848 -Dadmin.metadata-report.address=nacos://nacos:8848 -jar dubbo-admin-distribution-release.jar &

#nohup java $JAVA_OPTS -Ddubbo.registry.address=zookeeper://zookeeper:2181 -Dadmin.registry.address=zookeeper://zookeeper:2181 -Dadmin.config-center=zookeeper://zookeeper:2181 -Dadmin.metadata-report.address=zookeeper://zookeeper:2181 -jar dubbo-admin-distribution-release.jar &

tail -f /docker.sh
