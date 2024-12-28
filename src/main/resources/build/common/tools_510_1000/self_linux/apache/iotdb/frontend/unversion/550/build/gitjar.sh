#!/bin/sh
set -x

source /etc/profile;java -version



mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitcode.com/gh_mirrors/io/iotdb-web-workbench.git













/mvnclean.sh
