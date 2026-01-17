#!/bin/sh
set -x
source /etc/profile;java -version
export RUN_AS_USER=root
sh ${WS}/nexus/bin/nexus restart
tail -f ${WS}/sonatype-work/nexus3/*.log
