#!/bin/sh
set -x
source /etc/profile
cd /opt/soft/version
git clone https://e.coding.net/king019/github/nexus-public.git
cd nexus-public
git checkout release-3.7.0-04
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -T 2
cp /opt/soft/version/nexus-public/assemblies/nexus-base-template/target/nexus-base-template-3.7.0-04.zip /root/tools/nexus-base-template-3.7.0-04.zip
mvn clean
rm -fr ~/.m2/repository