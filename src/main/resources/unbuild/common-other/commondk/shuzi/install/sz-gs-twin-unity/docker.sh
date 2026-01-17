#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd gs-twin-unity
git pull
rm -fr ${WS}/tomcat/webapps/ROOT
cp -R ROOT ${WS}/tomcat/webapps/ROOT
cd ${WS}/tomcat/bin
sh shutdown.sh
sh startup.sh
tail -f /docker.sh
