#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/jenkins.git
cd jenkins
git checkout stable-2.289
cd war
mvn clean war:war -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip -T 2

cp target/jenkins.war /opt/soft/tools/jenkins.war

mvn clean
rm -fr ~/.m2/repository
