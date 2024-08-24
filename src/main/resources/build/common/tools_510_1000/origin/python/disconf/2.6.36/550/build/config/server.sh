#!/bin/sh
set -x

jetty_version=9.4.55.v20240627
tomcat_version=9.0.93


mvn dependency:get -Dtransitive=false -DgroupId=org.eclipse.jetty -DartifactId=jetty-distribution -Dversion=${jetty_version} -Dpackaging=tar.gz;cp /root/.m2/repository/org/eclipse/jetty/jetty-distribution/${jetty_version}/jetty-distribution-${jetty_version}.tar.gz /opt/soft/tool
mvn dependency:get -Dtransitive=false -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz;cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz /opt/soft/tool


cd /opt/soft/tool/;tar -xzf jetty-distribution-${jetty_version}.tar.gz
cd /opt/soft/tool/;mv jetty-distribution-${jetty_version} jetty


cd /opt/soft/tool;tar -xzf tomcat-${tomcat_version}.tar.gz
cd /opt/soft/tool;mv apache-tomcat-${tomcat_version} tomcat


cd /opt/soft/tool/tomcat/webapps;rm -fr *
mkdir -p /opt/soft/tool/tomcat/webapps

rm -fr /root/.m2/repository