#!/bin/sh
set -x
source /etc/profile
cd /root/tools/monitor/
sh assembly.bin/start.sh
tail -f /docker.sh
