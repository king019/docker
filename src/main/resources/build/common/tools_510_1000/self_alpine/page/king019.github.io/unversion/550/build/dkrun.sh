#!/bin/sh
set -x
source /etc/profile;java -version
/gitjar.sh
cd /opt/soft/version/ali_fw_blog/fw_blog/blog_github/github_king019

sh cmd/server.sh
