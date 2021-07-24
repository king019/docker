#!/bin/sh
set -x
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/arthas.git
cd arthas
git checkout arthas-all-3.5.0
mvn clean package -DskipTests -Dmaven.javadoc.skip=true -Dgpg.skip
find . -name arthas-boot-jar-with-dependencies.jar | awk '{print "cp " $1  " /opt/soft/arthas-boot.jar"}' | sh
mvn clean
rm -fr ~/.m2/repository
