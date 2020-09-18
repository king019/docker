#!/bin/sh
set -x
source /etc/profile
cd /root/tools
nohup java  $JAVA_OPTS -jar share_sentinel_apollo-1.0-SNAPSHOT.jar &
for ((i=1; i<=20; i++))
do
  nohup sh /curlRun.sh $SERVER_PORT  &
done
tail -f /docker.sh
