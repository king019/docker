#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/king019/gs-twin-ui.git

cd gs-twin-ui
git pull
sed -i s/192.168.3.4:9527/sz-gateway/g vue.config.js

npm install --registry=http://bk:8081/repository/npm/
npm run build:prod
mv ./dist /dist