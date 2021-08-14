#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3001/king019/ali_fw_blog.git
