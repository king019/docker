#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd energy-analysis-server
mvn spring-boot:run -T 100
tail -f /docker.sh
