#!/bin/sh
set -x
cd /opt/soft/version
git clone https://e.coding.net/king019/github/apollo.git
mvn versions:set -DnewVersion=release
cd apollo/scripts
sh ./build.sh
cd ..
cp ./apollo-portal/target/apollo-portal-release-github.zip /opt/soft/apollo-portal-release-github.zip
mvn clean
rm -fr ~/.m2/repository