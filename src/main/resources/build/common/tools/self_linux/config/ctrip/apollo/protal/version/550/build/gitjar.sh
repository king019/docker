#!/bin/sh
set -x
source /etc/profile;java -version
java -version
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/apollo.git
cd apollo
git checkout v1.9.2
mvn versions:set -DnewVersion=release
cd scripts
sh ./build.sh
cd ..
cp ./apollo-portal/target/apollo-portal-release-github.zip /opt/soft/apollo-portal-release-github.zip
mvn clean
/mvnclean.sh
