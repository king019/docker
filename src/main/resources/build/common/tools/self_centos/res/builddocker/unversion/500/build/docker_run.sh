#!/bin/sh
set -x

source /etc/profile
mkdir -p /root/soft
cd /root/soft
git clone https://github.com/king019/docker.git
cd docker
chmod -R 777 .
./src/main/resources/travis/travis.sh
