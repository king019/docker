#!/bin/sh
set -x
source /etc/profile;java -version
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://gitee.com/king019/zkui.git
cd zkui
mvn versions:set -DnewVersion=release
sed -i 's/<artifactId>maven-assembly-plugin<\/artifactId>/<artifactId>maven-assembly-plugin<\/artifactId><version>3.3.0<\/version>/g' pom.xml
mvn clean install -DskipTests -Dmaven.javadoc.skip=true
find . -name zkui-release-jar-with-dependencies.jar | awk '{print "cp " $1  " /opt/soft/zkui-release-jar-with-dependencies.jar"}' | sh
mvn clean
/mvnclean.sh
