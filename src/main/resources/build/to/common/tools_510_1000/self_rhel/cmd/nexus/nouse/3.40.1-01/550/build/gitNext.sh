#!/bin/sh
set -x
source /etc/profile;java -version
cd /${WS}
unzip nexus-base-template-${nexus_version}.zip
cd ${WS}
mv nexus-base-template-${nexus_version} nexus
