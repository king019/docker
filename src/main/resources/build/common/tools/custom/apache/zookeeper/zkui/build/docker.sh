#!/bin/sh
set -x
source /etc/profile
cd /opt/soft
nohup java -jar zkui-2.0-SNAPSHOT-jar-with-dependencies.jar >log.txt &


tail -f /docker.sh
