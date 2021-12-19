#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gogs:3001/king019/ali_fw_project.git
cd ali_fw_project
mvn clean package -DskipTests=true
find . -name fw_project_sonar-1.0-SNAPSHOT.jar | awk '{print "cp " $1  " /opt/soft/fw_project_sonar-1.0-SNAPSHOT.jar"}' | sh
mvn clean
/mvnclean.sh
