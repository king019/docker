#!/bin/sh
set -x
source /etc/profile;java -version
cd /opt/soft/
unzip nexus-base-template-${nexus_version}.zip
cd /opt/soft/
mv nexus-base-template-${nexus_version} nexus
