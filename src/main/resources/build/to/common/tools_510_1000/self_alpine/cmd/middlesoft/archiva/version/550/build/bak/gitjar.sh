#!/bin/sh
set -x
source /etc/profile;java -version
archiva_version=2.0.0
mvn dependency:get -Dtransitive=false -DgroupId=org.apache.archiva -DartifactId=archiva-jetty -Dversion=${archiva_version} -Dclassifier=bin -Dpackaging=tar.gz;cp /root/.m2/repository/org/apache/archiva/archiva-jetty/${archiva_version}/archiva-jetty-${archiva_version}-bin.tar.gz ${WS}
cd ${WS}
tar -xzf archiva-jetty-${archiva_version}-bin.tar.gz
mv apache-archiva-${archiva_version} archiva
