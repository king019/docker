#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/king019/opc-da-ui.git

cd opc-da-ui
sed -i 's/VUE_APP_PLATFORM_ENABLED = false/VUE_APP_PLATFORM_ENABLED = true/g'  ./.env.development
sed -i s/localhost:8080/sz-gateway/g ./vue.config.js
npm install --registry=http://bk:8081/repository/npm/
npm run build:prod
mv ./dist /dist