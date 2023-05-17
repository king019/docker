#!/bin/sh
set -x

jetty_version=9.4.51.v20230217
tomcat_version=9.0.75


mvn dependency:get -DgroupId=org.eclipse.jetty -DartifactId=jetty-distribution -Dversion=${jetty_version} -Dpackaging=tar.gz;cp /root/.m2/repository/org/eclipse/jetty/jetty-distribution/${jetty_version}/jetty-distribution-${jetty_version}.tar.gz /opt/soft/tools
mvn dependency:get -DgroupId=org.apache.tomcat -DartifactId=tomcat -Dversion=${tomcat_version} -Dpackaging=tar.gz;cp /root/.m2/repository/org/apache/tomcat/tomcat/${tomcat_version}/tomcat-${tomcat_version}.tar.gz /opt/soft/tools


cd /opt/soft/tools/;tar -xzf jetty-distribution-${jetty_version}.tar.gz
cd /opt/soft/tools/;mv jetty-distribution-${jetty_version} jetty


cd /opt/soft/tools;tar -xzf tomcat-${tomcat_version}.tar.gz
cd /opt/soft/tools;mv apache-tomcat-${tomcat_version} tomcat


cd /opt/soft/tools/tomcat/webapps;rm -fr *
mkdir -p /opt/soft/tools/tomcat/webapps

rm -fr /root/.m2/repository