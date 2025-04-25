#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/king019/message-center-ui.git

cd message-center-ui
npm install --registry=http://bk:8081/repository/npm/