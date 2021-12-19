#!/bin/sh
set -x
javah -version
source /etc/profile;java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/arthas.git
cd arthas
git checkout arthas-all-3.5.5
sed -i 's/<generateGitPropertiesFile>true<\/generateGitPropertiesFile>/<generateGitPropertiesFile>true<\/generateGitPropertiesFile><skip>true<\/skip>/' pom.xml
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name arthas-boot-jar-with-dependencies.jar | awk '{print "cp " $1  " /opt/soft/arthas-boot.jar"}' | sh
mvn clean
/mvnclean.sh
