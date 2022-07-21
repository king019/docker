#!/bin/sh
set -x
source /etc/profile;java -version

mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/jenkins.git
cd jenkins

git checkout stable-2.164
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp war/target/jenkins.war /opt/soft/tools/jenkins.war
cp /opt/soft/tools/jenkins.war /opt/soft/tools/tomcat/webapps/ROOT.war
mvn clean
/mvnclean.sh
