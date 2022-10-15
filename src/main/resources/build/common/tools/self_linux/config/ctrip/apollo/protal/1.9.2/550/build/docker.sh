#!/bin/sh
set -x

source /etc/profile;java -version

cd /opt/soft/apollo-portal/config
echo 'dev.meta='$DEV_MATA >apollo-env.properties
cd /opt/soft/apollo-portal/scripts
nohup sh startup.sh >log.txt &

tail -f /docker.sh
