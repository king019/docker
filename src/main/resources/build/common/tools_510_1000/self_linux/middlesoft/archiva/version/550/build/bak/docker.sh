#!/bin/sh
set -x
source /etc/profile;java -version
#sh /opt/soft/archiva/bin/archiva




#tail -f /opt/soft/sonatype-work/nexus3/*.log
mkdir -p /opt/soft/archiva
export JAVA_OPTS="-Dappserver.home=/opt/soft/archiva -Dappserver.base=/opt/soft/archiva"



cd /opt/soft/tool/tomcat/bin
./shutdown.sh
./startup.sh

tail -f /docker.sh
