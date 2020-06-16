#!/bin/sh
set -x
source /etc/profile
cd /root/tools/monitor/assembly.bin
sh restart.sh
tail -f /docker.sh
