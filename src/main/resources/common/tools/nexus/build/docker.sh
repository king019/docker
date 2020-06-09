#!/bin/sh
set -x
source /etc/profile

sh /root/tools/nexus/nexus/bin/nexus restart
tail -f /docker.sh
