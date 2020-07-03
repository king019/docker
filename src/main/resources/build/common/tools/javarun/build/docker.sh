#!/bin/sh
set -x
source /etc/profile
echo 'notice'> /root/notice.txt
cd /root/tools
nohup java -jar javarun.jar &
tail -f /docker.sh
