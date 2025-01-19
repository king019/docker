#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd sso-ui
git pull
sed -i s/192.168.3.4:9527/sz-gateway/g vue.config.js
cat vue.config.js
npm install --registry=http://bk:8081/repository/npm/
npm run dev
tail -f /docker.sh
