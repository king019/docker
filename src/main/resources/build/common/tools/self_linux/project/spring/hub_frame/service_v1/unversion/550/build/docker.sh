#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft
nohup java -jar /opt/soft/frame_boot_boot_service-release.jar &
tail -f /docker.sh
