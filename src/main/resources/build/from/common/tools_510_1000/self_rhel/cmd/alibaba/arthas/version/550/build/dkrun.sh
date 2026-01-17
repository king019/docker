#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}/ali_fw_sshm/fw_sshm/sshm_webmvc/sshm_boot/sshm_boot_function/sshm_boot_function_show
mvn spring-boot:start
#nohup mvn spring-boot:start > log.txt &
#sleep 10

cd ${WS}/arthas
#nohup java -jar /opt/soft/arthas-boot.jar &
#java -jar /opt/soft/arthas/arthas-boot.jar
