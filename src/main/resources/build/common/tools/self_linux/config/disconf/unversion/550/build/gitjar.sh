#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/disconf.git
cd /opt/soft/version/disconf
ONLINE_CONFIG_PATH=/conf
WAR_ROOT_PATH=/opt/soft/tools/tomcat/webapps/ROOT
export ONLINE_CONFIG_PATH
export WAR_ROOT_PATH
cd disconf-web
sh deploy/deploy.sh