#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/king019/ali_fw_sshm.git
cd ali_fw_sshm
cd $(find . -name 'sshm_boot_cloud_admin_server')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " ${WS}/sshm_boot_cloud_admin_server-release.jar"}' | sh
mvn clean
/mvnclean.sh
