#!/bin/sh
set -x
cd /opt/soft/version
git clone https://gitee.com/king019/ali_fw_sshm.git
cd ali_fw_sshm
mvn clean package -DskipTests -Dmaven.javadoc.skip=true
find . -name sshm_boot_cloud_grpc_provider-1.0-SNAPSHOT.jar|awk '{print "cp " $1  " /opt/soft/sshm_boot_cloud_grpc_provider-1.0-SNAPSHOT.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository