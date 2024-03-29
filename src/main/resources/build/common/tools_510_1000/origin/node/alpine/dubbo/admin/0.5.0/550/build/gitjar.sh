#!/bin/sh
set -x
source /etc/profile;java -version

#mkdir -p /root/.m2/repository/com/github/eirslett/node/9.11.1/
#cd /root/.m2/repository/com/github/eirslett/node/9.11.1/
#wget https://registry.npmmirror.com/-/binary/node/v9.11.1/node-v9.11.1-linux-x64.tar.gz
#wget https://registry.npmmirror.com/-/binary/node/v9.11.1/node-v9.11.1-linux-arm64.tar.gz


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/dubbo-admin.git

cd dubbo-admin
git checkout 0.5.0


cd dubbo-admin-ui
sed -i "s/port: 8082,/port: 8082,disableHostCheck: true,/g" ./vue.config.js
npm install -g @vue/cli
npm install


cd ..
mvn clean package -Dmaven.test.skip=true -pl dubbo-admin-server
cp dubbo-admin-server/target/dubbo-admin-server-0.5.0.jar /opt/soft/dubbo-admin-server.jar





cd /opt/soft/version
cd dubbo-admin
mvn clean
/mvnclean.sh
