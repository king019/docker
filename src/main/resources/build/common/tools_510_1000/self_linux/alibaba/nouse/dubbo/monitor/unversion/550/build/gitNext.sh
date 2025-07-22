#!/bin/sh
set -x

source /etc/profile;java -version
cd /opt/soft
tar -xzf dubbo-monitor-simple-2.5.10-assembly.tar.gz
mv dubbo-monitor-simple-2.5.10 monitor

