#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /opt/soft/version
cd /opt/soft/version

wget https://mirrors.huaweicloud.com/jenkins/war-stable/2.516.2/jenkins.war


cp jenkins.war /opt/soft/tool/jenkins.war
ls /opt/soft/tool
cp /opt/soft/tool/jenkins.war /opt/soft/tool/tomcat/webapps/ROOT.war
ls /opt/soft/tool/tomcat/
ls /opt/soft/tool/tomcat/webapps
