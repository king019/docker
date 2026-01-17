#!/bin/sh
set -x

source /etc/profile;java -version
cd ${WS}/apollo-admin/scripts
nohup sh startup.sh >>log.txt &
tail -f log.txt
