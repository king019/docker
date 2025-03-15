#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft

java ${JAVA_OPTS}  -jar ruoyi-modules-file.jar
tail -f /docker.sh
