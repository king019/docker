#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd RuoYi-Cloud
mvn install
cd ruoyi-modules/ruoyi-job
mvn spring-boot:run -T 100
tail -f /docker.sh
