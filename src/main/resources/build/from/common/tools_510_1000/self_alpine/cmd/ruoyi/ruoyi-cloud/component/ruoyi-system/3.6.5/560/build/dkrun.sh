#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}

java ${JAVA_OPTS}  -jar ruoyi-modules-system.jar
tail -f /docker.sh
