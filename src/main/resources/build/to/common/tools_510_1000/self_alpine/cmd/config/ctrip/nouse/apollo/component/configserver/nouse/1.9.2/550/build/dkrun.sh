#!/bin/sh
set -x

source /etc/profile;java -version
cd ${WS}/apollo-configservice/scripts
nohup sh startup.sh >log.txt &

