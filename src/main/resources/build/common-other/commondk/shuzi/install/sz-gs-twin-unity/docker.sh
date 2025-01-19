#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd gs-twin-unity
git pull
rm -fr /opt/soft/tool/tomcat/webapps/ROOT
cp -R ROOT /opt/soft/tool/tomcat/webapps/ROOT
cd /opt/soft/tool/tomcat/bin
sh shutdown.sh
sh startup.sh
tail -f /docker.sh
