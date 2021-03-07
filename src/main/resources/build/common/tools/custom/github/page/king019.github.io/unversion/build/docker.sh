#!/bin/sh
set -x
source /etc/profile
/gitjar.sh
cd /opt/soft/version/ali_fw_blog/fw_blog/blog_github/github_king019
sh cmd/server.sh   
tail -f /docker.sh
