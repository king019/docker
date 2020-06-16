#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java -jar dubbo-admin-0.2.0.jar &
tail -f /docker.sh
