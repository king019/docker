#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd low-server-ui
git pull
sh cmd.sh
npm run dev
tail -f /docker.sh
