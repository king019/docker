#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/ali_fw_sshm.git
cd ali_fw_sshm
cd $(find . -name 'sshm_boot_cloud_feign_nacos_server')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name sshm_boot_cloud_feign_nacos_server-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/sshm_boot_cloud_feign_nacos_server-release.jar"}' | sh
mvn clean
/mvnclean.sh
