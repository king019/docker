#!/bin/sh
set -x
source /etc/profile;
java -version
mkdir -p /opt/soft/version
cd /opt/soft/hub_git
sh README.md
cd /opt/soft/version/aliyun/ali_fw_frame
mvn install
