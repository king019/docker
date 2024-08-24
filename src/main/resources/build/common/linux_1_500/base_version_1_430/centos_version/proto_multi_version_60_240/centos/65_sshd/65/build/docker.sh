#!/bin/sh
set -x
source /etc/profile;echo ''
/multi.sh
tail -f /docker.sh
