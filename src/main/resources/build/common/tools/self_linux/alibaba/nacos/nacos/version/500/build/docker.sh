#!/bin/sh
set -x
source /etc/profile
cd /opt/soft/nacos/bin
sh startup.sh -m standalone


tail -f /docker.sh
