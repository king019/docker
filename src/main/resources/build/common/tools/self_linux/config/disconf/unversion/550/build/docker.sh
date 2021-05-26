#!/bin/sh
set -x
source /etc/profile

cd /opt/soft/version/disconf
ONLINE_CONFIG_PATH=/conf
WAR_ROOT_PATH=/home/work/dsp/disconf-rd/war
export ONLINE_CONFIG_PATH
export WAR_ROOT_PATH
cd disconf-web
sh deploy/deploy.sh

tail -f /docker.sh
