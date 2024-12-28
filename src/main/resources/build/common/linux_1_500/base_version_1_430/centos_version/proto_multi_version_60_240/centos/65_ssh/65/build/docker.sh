#!/bin/sh
set -x
source /etc/profile;echo ''
chmod -R /*.sh
/multi.sh
tail -f /docker.sh
