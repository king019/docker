#!/bin/sh
set -x

jetty_version=12.1.0
tomcat_version=11.0.10



#https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/12.1.0/jetty-home-12.1.0.tar.gz

mvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-home -Dversion=${jetty_version} -Dpackaging=tar.gz -Dtransitive=false;cp /root/.m2/repository/org/eclipse/jetty/jetty-home/${jetty_version}/jetty-home-${jetty_version}.tar.gz /opt/soft/tool
mvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz -Dtransitive=false;cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz /opt/soft/tool


cd /opt/soft/tool/;tar -xzf jetty-home-${jetty_version}.tar.gz
cd /opt/soft/tool/;mv jetty-home-${jetty_version} jetty


cd /opt/soft/tool;tar -xzf tomcat-${tomcat_version}.tar.gz
cd /opt/soft/tool;mv apache-tomcat-${tomcat_version} tomcat


cd /opt/soft/tool/tomcat/webapps;rm -fr *
mkdir -p /opt/soft/tool/tomcat/webapps

rm -fr /root/.m2/repository