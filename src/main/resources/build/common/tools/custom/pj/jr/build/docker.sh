#!/bin/sh
set -x
cd /opt/soft/;
java -jar JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT.jar -p $PORT

tail -f /docker.sh
