#!/bin/sh
set -x

jetty_version=12.1.0
tomcat_version=11.0.10



#https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/12.1.0/jetty-home-12.1.0.tar.gz

mvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-home -Dversion=${jetty_version} -Dpackaging=tar.gz -Dtransitive=false;cp /root/.m2/repository/org/eclipse/jetty/jetty-home/${jetty_version}/jetty-home-${jetty_version}.tar.gz ${WS}
mvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz -Dtransitive=false;cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz ${WS}


cd ${WS};tar -xzf jetty-home-${jetty_version}.tar.gz
cd ${WS};mv jetty-home-${jetty_version} jetty


cd ${WS};tar -xzf tomcat-${tomcat_version}.tar.gz
cd ${WS};mv apache-tomcat-${tomcat_version} tomcat


cd ${WS}/tomcat/webapps;rm -fr *
mkdir -p ${WS}/tomcat/webapps

rm -fr /root/.m2/repository