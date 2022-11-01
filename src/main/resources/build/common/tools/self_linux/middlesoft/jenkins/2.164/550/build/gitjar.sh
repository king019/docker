#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /root/.m2/repository/com/github/eirslett/node/6.10.2/
cd /root/.m2/repository/com/github/eirslett/node/6.10.2/
wget https://registry.npmmirror.com/-/binary/node/v6.10.2/node-v6.10.2-linux-x64.tar.gz
wget https://registry.npmmirror.com/-/binary/node/v6.10.2/node-v6.10.2-linux-arm64.tar.gz


mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/jenkins.git
cd jenkins

git checkout stable-2.164


#cd war
#sed -i 's/<\/nodeDownloadRoot>/<\/nodeDownloadRoot><downloadRoot>http:\/\/npm.taobao.org\/mirrors\/node\/<\/downloadRoot>/' pom.xml
#cd ..
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

ls war/target/
cp war/target/jenkins.war /opt/soft/tools/jenkins.war
ls /opt/soft/tools
cp /opt/soft/tools/jenkins.war /opt/soft/tools/tomcat/webapps/ROOT.war
ls /opt/soft/tools/tomcat/
mvn clean
/mvnclean.sh
