#!/bin/sh
set -x
source /etc/profile
cd /opt/soft/hub_frame/jvm/jvm_gc/jvm_gc_g1
sh start.txt
cd /opt/soft
nohup java -jar /opt/soft/arthas-boot.jar &

tail -f /docker.sh
