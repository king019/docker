#!/bin/sh
set -x

source /etc/profile;java -version
cd /opt/soft/apollo-adminservice/scripts
nohup sh startup.sh >log.txt &
