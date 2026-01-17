#!/bin/sh
set -x
source /etc/profile;java -version

cd /opt/soft
unzip nacos-server-${nacos_version}.zip
cat /application.properties > /opt/soft/nacos/conf/application.properties
