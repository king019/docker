#!/bin/sh
set -x
source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/mirrors/nexus-public.git
cd nexus-public


nexus_version=3.50.0-01
git checkout release-${nexus_version}
sed -i 's/<\/yarnVersion>/<\/yarnVersion><nodeDownloadRoot>https:\/\/mirrors.huaweicloud.com\/nodejs\/<\/nodeDownloadRoot><npmDownloadRoot>https:\/\/mirrors.huaweicloud.com\/npm\/<\/npmDownloadRoot><yarnDownloadRoot>https:\/\/mirrors.huaweicloud.com\/yarn\/<\/yarnDownloadRoot>/g' ./pom.xml
mvn clean install -DskipTests -Dmaven.javadoc.skip=true
cp ${WS}/nexus-public/assemblies/nexus-base-template/target/nexus-base-template-${nexus_version}.zip /opt/soft/nexus-base-template-${nexus_version}.zip
mvn clean
/mvnclean.sh
cd ${WS}
unzip nexus-base-template-${nexus_version}.zip
cd ${WS}
mv nexus-base-template-${nexus_version} nexus
