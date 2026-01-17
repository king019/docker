#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
java -jar ${WS}/renren-fast.jar