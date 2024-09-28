#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd RuoYi-Cloud
mvn install
cd ruoyi-visual/ruoyi-monitor
mvn spring-boot:run -T 100
tail -f /docker.sh
