#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd opc-da-ui
cat cmd.sh
sh cmd.sh
npm run dev
tail -f /docker.sh