#!/bin/sh
set -x


mkdir -p /opt/soft/version
cd /opt/soft/version
cd dubbo-admin


cd dubbo-admin-ui





sed -i "s/port: 38082,/port: 38082,disableHostCheck: true,/g" ./vue.config.js
npm install -g @vue/cli  --save
#npm install -g vue-cli@5.0.8 --save
npm install
npm run build
ls
