#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/nexus-public.git
cd nexus-public


nexus_version=3.40.1-01
git checkout release-${nexus_version}
sed -i 's/<\/yarnVersion>/<\/yarnVersion><nodeDownloadRoot>https:\/\/mirrors.huaweicloud.com\/nodejs\/<\/nodeDownloadRoot><npmDownloadRoot>https:\/\/mirrors.huaweicloud.com\/npm\/<\/npmDownloadRoot><yarnDownloadRoot>https:\/\/mirrors.huaweicloud.com\/yarn\/<\/yarnDownloadRoot>/g' ./pom.xml
mvn clean install -DskipTests -Dmaven.javadoc.skip=true
find . -name nexus-base-template-${nexus_version}.zip | awk -v nexus_version=${nexus_version}  '{print "cp " $1  " /opt/soft/nexus-base-template-"nexus_version".zip"}' | sh
