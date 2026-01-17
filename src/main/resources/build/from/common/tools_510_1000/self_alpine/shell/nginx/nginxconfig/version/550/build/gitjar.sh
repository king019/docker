#!/bin/sh
set -x
cd ${WS}
git clone https://gitee.com/king019/nginxconfig.io.git
cd nginxconfig.io
#npm ci --registry=http://nexus:8081/repository/npm/
npm ci
npm run build
npm run build:template
npm run build:prism
#npm install pnpm --registry=http://nexus:8081/repository/npm/
#npm run build --registry=http://nexus:8081/repository/npm/
#mv ./dist /dist