#!/bin/sh
set -x
source /etc/profile;java -version

mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/jenkins.git
cd jenkins
git checkout stable-2.289
cd war
mvn clean war:war -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip

cp target/jenkins.war /opt/soft/tools/jenkins.war
cp /opt/soft/tools/jenkins.war /opt/soft/tools/tomcat/webapps/ROOT.war
mvn clean
/mvnclean.sh
