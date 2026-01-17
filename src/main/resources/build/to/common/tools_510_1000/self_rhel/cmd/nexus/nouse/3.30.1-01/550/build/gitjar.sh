#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/nexus-public.git
cd nexus-public


nexus_version=3.30.1-01
git checkout release-${nexus_version}
sed -i 's/<\/yarnVersion>/<\/yarnVersion><nodeDownloadRoot>https:\/\/mirrors.huaweicloud.com\/nodejs\/<\/nodeDownloadRoot><npmDownloadRoot>https:\/\/mirrors.huaweicloud.com\/npm\/<\/npmDownloadRoot><yarnDownloadRoot>https:\/\/mirrors.huaweicloud.com\/yarn\/<\/yarnDownloadRoot>/g' ./pom.xml
mvn clean install -DskipTests -Dmaven.javadoc.skip=true
cp /opt/soft/version/nexus-public/assemblies/nexus-base-template/target/nexus-base-template-${nexus_version}.zip /opt/soft/nexus-base-template-${nexus_version}.zip
mvn clean
/mvnclean.sh
cd /opt/soft/
unzip nexus-base-template-${nexus_version}.zip
cd /opt/soft/
mv nexus-base-template-${nexus_version} nexus
