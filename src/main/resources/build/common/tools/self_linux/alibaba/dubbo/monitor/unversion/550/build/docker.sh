#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft/monitor/
sh bin/start.sh
tail -f /docker.sh
