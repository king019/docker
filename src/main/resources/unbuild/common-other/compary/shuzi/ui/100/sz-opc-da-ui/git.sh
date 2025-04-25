#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/king019/opc-da-ui.git

cd opc-da-ui
npm install --registry=http://bk:8081/repository/npm/