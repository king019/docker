#!/bin/sh
set -x
cd /opt/soft/tool/JrebelLicenseServerforJava/target;
java -jar JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT.jar -p $PORT
tail -f /docker.sh
