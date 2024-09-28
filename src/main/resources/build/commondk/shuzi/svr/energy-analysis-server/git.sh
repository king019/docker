#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/king019/energy-analysis-server.git

