#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/k/RuoYi-Cloud.git
#cd RuoYi-Cloud
#mvn install -T 100
