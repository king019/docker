#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/disconf.git
cd /opt/soft/version/disconf

sed -i 's/<java.version>1.6<\/java.version>/<java.version>1.8<\/java.version>/' pom.xml
sed -i 's/<source.version>1.6<\/source.version>/<source.version>1.8<\/source.version>/' pom.xml
sed -i 's/<target.version>1.6<\/target.version>/<target.version>1.8<\/target.version>/' pom.xml

cat pom.xml

ONLINE_CONFIG_PATH=/conf
WAR_ROOT_PATH=/opt/soft/tools/tomcat/webapps/ROOT
export ONLINE_CONFIG_PATH
export WAR_ROOT_PATH
cd disconf-web
sh deploy/deploy.sh
