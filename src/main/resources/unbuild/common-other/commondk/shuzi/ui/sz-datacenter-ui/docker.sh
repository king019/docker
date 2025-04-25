#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd datacenter-ui
sed -i s/localhost:9527/sz-gateway/g vue.config.js
cat vue.config.js
npm install --registry=http://bk:8081/repository/npm/
npm run dev
tail -f /docker.sh
