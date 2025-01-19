#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd RuoYi-Cloud
mvn install
cd ruoyi-modules/ruoyi-file
mvn spring-boot:run -T 100
tail -f /docker.sh
