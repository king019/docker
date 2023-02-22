#!/bin/sh
set -x

source /etc/profile;
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/hub_frame.git
cd /opt/soft/version/hub_frame
mvn install package

cd /opt/soft/version/hub_frame/fw_frame/frame_jvm/frame_jvm_gc/frame_jvm_gc_g1
mvn spring-boot:stop
