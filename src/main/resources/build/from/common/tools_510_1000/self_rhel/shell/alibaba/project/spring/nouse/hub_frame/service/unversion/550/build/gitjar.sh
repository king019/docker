#!/bin/sh
set -x
source /etc/profile;
java -version
cd ${WS}
git clone https://gitee.com/king019/hub_frame.git
cd hub_frame
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -Dmaven.source.skip=true
find . -name frame_boot_boot_service-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " ${WS}/frame_boot_boot_service-release.jar"}' | sh
mvn clean
/mvnclean.sh
