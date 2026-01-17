#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}

#nohup java $JAVA_OPTS -Dadmin.registry.address=zookeeper://zookeeper:2181 -Dadmin.config-center=zookeeper://zookeeper:2181 -Dadmin.metadata-report.address=zookeeper://zookeeper:2181 -jar dubbo-admin-server.jar &

java $JAVA_OPTS -Dadmin.registry.address=nacos://nacos:8848 -Dadmin.config-center=nacos://nacos:8848 -Dadmin.metadata-report.address=nacos://nacos:8848 -jar dubbo-admin-server.jar

tail -f /docker.sh
