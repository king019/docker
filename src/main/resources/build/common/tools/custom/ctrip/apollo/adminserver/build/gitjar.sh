#!/bin/sh
set -x
source /etc/profile
java -version
cd /opt/soft/version
git clone https://e.coding.net/king019/github/apollo.git
cd apollo
mvn versions:set -DnewVersion=release
cd scripts
sh ./build.sh

cd ..
cp ./apollo-adminservice/target/apollo-adminservice-release-github.zip /opt/soft/apollo-adminservice-release-github.zip
mvn clean
rm -fr ~/.m2/repository