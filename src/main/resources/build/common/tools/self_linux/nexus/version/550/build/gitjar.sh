#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/nexus-public.git
cd nexus-public
git checkout release-3.7.0-04
mvn clean install -DskipTests -Dmaven.javadoc.skip=true
cp /opt/soft/version/nexus-public/assemblies/nexus-base-template/target/nexus-base-template-3.7.0-04.zip /opt/soft/nexus-base-template-3.7.0-04.zip
mvn clean
/mvnclean.sh
cd /opt/soft/
unzip nexus-base-template-3.7.0-04.zip
cd /opt/soft/
mv nexus-base-template-3.7.0-04 nexus
