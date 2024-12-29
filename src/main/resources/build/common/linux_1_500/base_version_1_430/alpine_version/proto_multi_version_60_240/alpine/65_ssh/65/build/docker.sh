#!/bin/sh
set -x
source /etc/profile;echo ''
chmod -R 777 /*.sh
/multi.sh
tail -f /docker.sh
