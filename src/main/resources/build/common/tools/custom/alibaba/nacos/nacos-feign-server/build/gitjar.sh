#!/bin/sh
set -x
cd /opt/soft/version
git clone https://github.com/king019/ali_fw_sshm.git
cd ali_fw_sshm
mvn clean package -DskipTests -Dmaven.javadoc.skip=true
find . -name sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/sshm_cloud_feign_nacos_server-1.0-SNAPSHOT.jar"}'|sh
mvn clean