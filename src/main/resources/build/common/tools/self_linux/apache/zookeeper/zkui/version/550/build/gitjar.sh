#!/bin/sh
set -x
source /etc/profile
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/zkui.git
cd zkui
mvn versions:set -DnewVersion=release
sed -i 's/<artifactId>maven-assembly-plugin<\/artifactId>/<artifactId>maven-assembly-plugin<\/artifactId><version>3.3.0<\/version>/g' pom.xml
mvn clean install -DskipTests -Dmaven.javadoc.skip=true -T 2
find . -name zkui-release-jar-with-dependencies.jar|awk '{print "cp " $1  " /opt/soft/zkui-release-jar-with-dependencies.jar"}'|sh
mvn clean
rm -fr ~/.m2/repository