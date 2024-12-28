#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd RuoYi-Cloud
git pull
cd ruoyi-ui
sed -i s/localhost:8080/ruoyi-gateway/g vue.config.js
cat vue.config.js
npm install --registry=https://registry.npmmirror.com/
npm run dev
tail -f /docker.sh
