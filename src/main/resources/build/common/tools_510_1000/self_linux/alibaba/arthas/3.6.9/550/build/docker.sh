#!/bin/sh
set -x
source /etc/profile;java -version


cd /opt/soft
nohup java -jar /opt/soft/arthas-boot.jar &

tail -f /docker.sh
