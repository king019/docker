#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}/monitor/
sh bin/start.sh
sleep 10
tail -f logs/*
