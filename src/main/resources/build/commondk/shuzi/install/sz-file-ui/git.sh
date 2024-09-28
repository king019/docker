#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version

git clone http://gitea:3000/king019/file-ui.git

cd file-ui
git pull
#sed -i s/139.159.183.75:15000/sz-gateway/g vue.config.js
cat vue.config.js
npm install --registry=http://bk:8081/repository/npm/