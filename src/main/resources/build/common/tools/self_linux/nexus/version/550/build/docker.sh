#!/bin/sh
set -x
source /etc/profile
export RUN_AS_USER=root
sh /opt/soft/nexus/bin/nexus restart
tail -f  /opt/soft/sonatype-work/nexus3/*.log


tail -f /docker.sh
