#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
nohup java -jar zkui-release-jar-with-dependencies.jar >log.txt &
tail -f log.txt
