#!/bin/sh
set -x

source /etc/profile;java -version

cd ${WS}/apollo-portal/config
echo 'dev.meta='$DEV_MATA >apollo-env.properties
cd ${WS}/apollo-portal/scripts
nohup sh startup.sh >>log.txt &
tail -f log.txt
