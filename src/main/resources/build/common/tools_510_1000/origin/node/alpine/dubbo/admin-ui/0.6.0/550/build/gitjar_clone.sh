#!/bin/sh
set -x


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/dubbo-admin.git
dubbo_admin_version=0.6.0
cd dubbo-admin
git checkout ${dubbo_admin_version}
