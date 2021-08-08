#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/ali_fw_sshm.git
cd ali_fw_sshm
cd $(find . -name 'sshm_boot_cloud_admin_server')
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name sshm_boot_cloud_admin_server-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/sshm_boot_cloud_admin_server-release.jar"}' | sh
mvn clean
rm -fr ~/.m2/repository
