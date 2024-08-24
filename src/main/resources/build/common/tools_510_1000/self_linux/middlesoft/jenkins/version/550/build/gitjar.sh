#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /opt/soft/version
cd /opt/soft/version

wget https://repo.huaweicloud.com/jenkins/war/2.471/jenkins.war
#wget https://repo.huaweicloud.com/jenkins/war/latest/jenkins.war

cp jenkins.war /opt/soft/tool/jenkins.war
ls /opt/soft/tool
cp /opt/soft/tool/jenkins.war /opt/soft/tool/tomcat/webapps/ROOT.war
ls /opt/soft/tool/tomcat/
ls /opt/soft/tool/tomcat/webapps
