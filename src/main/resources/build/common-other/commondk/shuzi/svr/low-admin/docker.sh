#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd low-server
mvn install
cd low-admin
mvn spring-boot:run -T 100
tail -f /docker.sh
