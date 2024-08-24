#!/bin/sh
set -x
source /etc/profile;java -version
export RUN_AS_USER=root
sh /opt/soft/nexus/bin/nexus restart
tail -f /opt/soft/sonatype-work/nexus3/*.log
