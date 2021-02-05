#!/bin/sh
set -x
source /etc/profile
export RUN_AS_USER=root
sh /root/tools/nexus/bin/nexus restart
tail -f /docker.sh
