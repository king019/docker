#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/nexus-public.git
cd nexus-public
git checkout release-3.8.0-02
mvn versions:set -DnewVersion=release
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -T 2
cp /opt/soft/version/nexus-public/assemblies/nexus-base-template/target/nexus-base-template-release.zip  /root/tools/nexus-base-template-release.zip
mvn clean
rm -fr ~/.m2/repository
cd /root/tools/;unzip nexus-base-template-release.zip
cd /root/tools/;mv nexus-base-template-release nexus