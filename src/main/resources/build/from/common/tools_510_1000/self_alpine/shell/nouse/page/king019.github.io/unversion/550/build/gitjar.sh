#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone http://gitea:3001/king019/ali_fw_blog.git
