#!/bin/sh
set -x
source /etc/profile
cd /root/tools/nacos/bin
sh startup.sh -m standalone


tail -f /docker.sh
