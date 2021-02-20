#!/bin/sh
set -x
source /etc/profile
cd /opt/soft/monitor/
sh assembly.bin/start.sh
tail -f /docker.sh
