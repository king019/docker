#!/bin/sh
set -x
source /etc/profile;java -version


mkdir -p /opt/soft/version
cd /opt/soft/version



wget https://repo.jenkins-ci.org/artifactory/releases/org/jenkins-ci/main/jenkins-war/2.390/jenkins-war-2.390.war

cp jenkins-war-2.390.war /opt/soft/tools/jenkins.war
ls /opt/soft/tools
cp /opt/soft/tools/jenkins.war /opt/soft/tools/tomcat/webapps/ROOT.war
ls /opt/soft/tools/tomcat/
ls /opt/soft/tools/tomcat/webapps
