#!/bin/sh
set -x
source /etc/profile;
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/hub_frame.git
cd hub_frame
mvn package
find . -name frame_boot_boot_service_v2-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/frame_boot_boot_service-release.jar"}' | sh
mvn clean
/mvnclean.sh
