#!/bin/sh
set -x
source /etc/profile

sh /root/tools/nexus/bin/nexus restart
tail -f /docker.sh
