#!/bin/sh
set -x

source /etc/profile;
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/hub_frame.git
cd /opt/soft/version
cd hub_frame
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -Dmaven.source.skip=true


find . -name frame_jvm_gc_admin-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/frame_jvm_gc_admin-1.0-SNAPSHOT.jar"}' | sh
find . -name frame_jvm_gc-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/frame_jvm_gc-1.0-SNAPSHOT.jar"}' | sh
mvn clean
/mvnclean.sh
cd /opt/soft
chmod -R 777 .
