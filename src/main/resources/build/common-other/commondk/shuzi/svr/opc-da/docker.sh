#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd opc-da
mvn install
cd sun-admin
mvn spring-boot:run -T 100
tail -f /docker.sh
