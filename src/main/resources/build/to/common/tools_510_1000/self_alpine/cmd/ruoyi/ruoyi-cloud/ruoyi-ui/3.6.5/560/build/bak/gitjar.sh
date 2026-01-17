#!/bin/sh
set -x

node --version

cd ${WS}
ruoyi_version=3.6.5
git clone https://gitee.com/y_project/RuoYi-Cloud.git
cd RuoYi-Cloud
git checkout v${ruoyi_version}
cd ruoyi-ui
sed -i s/localhost:8080/ruoyi-gateway/g vue.config.js
npm install --registry=https://registry.npmmirror.com
