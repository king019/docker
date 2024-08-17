#!/bin/sh
set -x
source /etc/profile;java -version

mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/mirrors/jenkins.git
cd jenkins

git checkout jenkins-2.389

mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -Denforcer.skip=true

ls war/target/
cp war/target/jenkins.war /opt/soft/tool/jenkins.war
ls /opt/soft/tool
cp /opt/soft/tool/jenkins.war /opt/soft/tool/tomcat/webapps/ROOT.war
ls /opt/soft/tool/tomcat/
mvn clean
/mvnclean.sh