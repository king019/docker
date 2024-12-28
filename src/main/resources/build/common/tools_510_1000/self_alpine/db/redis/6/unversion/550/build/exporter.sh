#!/bin/sh
set -x
cd /opt/soft


tar -xzf redis_exporter-v1.62.0.linux-amd64.tar.gz
mv redis_exporter-v1.62.0.linux-amd64  redis_exporter
cd redis_exporter
nohup ./redis_exporter &

