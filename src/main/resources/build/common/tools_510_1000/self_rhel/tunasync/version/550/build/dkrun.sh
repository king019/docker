#!/bin/sh
set -x
source /etc/profile;

mkdir -p /root/sync/cgroup
mkdir -p /root/sync/log
mkdir -p /root/sync/data
cd /opt/soft/tunasync


nohup ./tunasync manager --config ./manager.conf &
sleep 5
nohup ./tunasync worker --config ./worker.conf &



#    ./tunasynctl list -p 12345 --all
