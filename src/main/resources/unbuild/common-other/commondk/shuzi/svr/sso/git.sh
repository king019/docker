#!/bin/sh
set -x
source /etc/profile;echo ''
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone http://gitea:3000/king019/sso.git
cd sso
sed -i 's/<java.version>1.8<\/java.version>/<java.version>11<\/java.version>/g' pom.xml
cd sun-admin
sed -i '57a <dependency><groupId>javax.xml.bind<\/groupId><artifactId>jaxb-api<\/artifactId><version>2.3.0<\/version><\/dependency>' pom.xml
sed -i '57a <dependency><groupId>com.sun.xml.bind<\/groupId><artifactId>jaxb-impl<\/artifactId><version>2.3.0<\/version><\/dependency>' pom.xml
sed -i '57a <dependency><groupId>com.sun.xml.bind<\/groupId><artifactId>jaxb-core<\/artifactId><version>2.3.0<\/version><\/dependency>' pom.xml
sed -i '57a <dependency><groupId>javax.activation<\/groupId><artifactId>activation<\/artifactId><version>1.1.1<\/version><\/dependency>' pom.xml