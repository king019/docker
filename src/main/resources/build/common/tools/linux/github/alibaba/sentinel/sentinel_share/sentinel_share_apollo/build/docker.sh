#!/bin/sh
set -x
source /etc/profile
cd /root/tools
java  $JAVA_OPTS share_sentinel_apollo-1.0-SNAPSHOT.jar
sh /curlRun.sh
tail -f /docker.sh
