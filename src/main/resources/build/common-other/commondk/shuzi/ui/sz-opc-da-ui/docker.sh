#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd opc-da-ui
git pull
sed -i s/localhost:8080/sz-gateway/g vue.config.js
cat vue.config.js
npm install --registry=http://bk:8081/repository/npm/
npm run dev
tail -f /docker.sh
