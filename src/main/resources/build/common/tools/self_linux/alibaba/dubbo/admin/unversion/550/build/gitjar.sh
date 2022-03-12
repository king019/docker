#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/dubbo-admin.git

cd dubbo-admin
git checkout 0.4.0
cd dubbo-admin-server
mvn clean package -Dmaven.test.skip=true
cp target/dubbo-admin-server-0.4.0.jar /opt/soft/dubbo-admin-server.jar
cd ..
cd dubbo-admin-ui
sed -i "s/port: 8082,/port: 8082,disableHostCheck: true,/g" ./vue.config.js
npm install -g @vue/cli
npm install


cd /opt/soft/version
cd dubbo-admin
mvn clean
/mvnclean.sh
