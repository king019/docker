#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd message-center-ui
git pull
sed -i s/139.159.183.75:15000/sz-gateway/g vue.config.js
cat vue.config.js
npm install --registry=http://bk:8081/repository/npm/
npm run dev
tail -f /docker.sh
