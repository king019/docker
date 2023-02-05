#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/aliyun/ali_fw_sshm.git
cd /opt/soft/version/ali_fw_sshm/fw_sshm/sshm_webmvc/sshm_boot/sshm_boot_function/sshm_boot_function_show
mvn spring-boot:stop
nohup mvn spring-boot:start > log.txt &
sleep 10