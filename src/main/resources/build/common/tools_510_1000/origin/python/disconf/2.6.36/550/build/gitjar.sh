#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
mkdir -p /war
cd /opt/soft/version
git clone https://gitee.com/mirrors/disconf.git
cd /opt/soft/version/disconf
git checkout 2.6.36
#sed -i 's/<java.version>1.6<\/java.version>/<java.version>1.8<\/java.version>/' pom.xml
#sed -i 's/<source.version>1.6<\/source.version>/<source.version>1.8<\/source.version>/' pom.xml
#sed -i 's/<target.version>1.6<\/target.version>/<target.version>1.8<\/target.version>/' pom.xml

#cat pom.xml

ONLINE_CONFIG_PATH=/conf
WAR_ROOT_PATH=/war
export ONLINE_CONFIG_PATH
export WAR_ROOT_PATH
cd disconf-web
sh deploy/deploy.sh
cd /opt/soft/tools/tomcat/
cd /opt/soft/tools/tomcat/conf
sed -i 's/<\/Host>/<Context path="" docBase="\/war"\/><\/Host>/' server.xml

#<Context path="" docBase="/war"></Context>
#<Context path="" docBase="\/war"\/><\/Host>
#</Host>

#使用disconf域名
