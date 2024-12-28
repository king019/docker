#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft/nacos/bin
sh shutdown.sh
sh startup.sh -m standalone
tail -f /opt/soft/nacos/logs/start.out
