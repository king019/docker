#!/bin/sh
set -x

source /etc/profile;java -version
cd ${WS}
git clone https://gitee.com/king019/dubbo-admin.git
dubbo_admin_version=0.6.0
cd dubbo-admin
git checkout ${dubbo_admin_version}

cd dubbo-admin-ui


sed -i 's/<\/nodeVersion>/<\/nodeVersion><nodeDownloadRoot>https:\/\/mirrors.huaweicloud.com\/nodejs\/<\/nodeDownloadRoot><npmDownloadRoot>https:\/\/mirrors.huaweicloud.com\/npm\/<\/npmDownloadRoot><yarnDownloadRoot>https:\/\/mirrors.huaweicloud.com\/yarn\/<\/yarnDownloadRoot>/g' ./pom.xml


sed -i "s/port: 38082,/port: 38082,disableHostCheck: true,/g" ./vue.config.js

mvn install
