#!/bin/sh
set -x
source /etc/profile;java -version



cd /opt/soft/version/ali_fw_sshm/fw_sshm/webmvc/sshm_boot/sshm_boot_function/sshm_function_show
mvn spring-boot:stop
nohup mvn spring-boot:start > log.txt &
sleep 10

cd /opt/soft
nohup java -jar /opt/soft/arthas-boot.jar &

tail -f /docker.sh
