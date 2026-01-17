#!/bin/sh
set -x

source /etc/profile;java -version



cd ${WS}
git clone https://gitcode.com/gh_mirrors/io/iotdb-web-workbench.git
