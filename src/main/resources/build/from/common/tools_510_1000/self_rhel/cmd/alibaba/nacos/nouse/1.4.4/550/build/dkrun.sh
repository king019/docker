#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}/nacos/bin
sh shutdown.sh
sh startup.sh -m standalone

