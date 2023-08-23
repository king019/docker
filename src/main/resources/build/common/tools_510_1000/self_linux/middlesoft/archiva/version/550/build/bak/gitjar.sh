#!/bin/sh
set -x
source /etc/profile;java -version
mkdir -p /opt/soft/version
#mvn dependency:get -DgroupId=org.apache.archiva -DartifactId=archiva-jetty -Dversion=2.2.10 -Dclassifier=bin -Dpackaging=tar.gz;cp /root/.m2/repository/org/apache/archiva/archiva-jetty/2.2.10/archiva-jetty-2.2.10-bin.tar.gz /opt/soft/
#cd /opt/soft/
#tar -xzf archiva-jetty-2.2.10-bin.tar.gz
#mv apache-archiva-2.2.10 archiva








mvn dependency:get -DgroupId=org.apache.derby -DartifactId=derby -Dversion=10.10.1.1  -Dpackaging=jar;cp /root/.m2/repository/org/apache/derby/derby/10.1.3.1/derby-10.1.3.1.jar /opt/soft/
mvn dependency:get -DgroupId=javax.activation -DartifactId=activation -Dversion=1.1.1  -Dpackaging=jar;cp /root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar /opt/soft/
mvn dependency:get -DgroupId=javax.mail -DartifactId=mail -Dversion=1.4  -Dpackaging=jar;cp /root/.m2/repository/javax/mail/mail/1.4/mail-1.4.jar /opt/soft/


cp /opt/soft/derby-10.10.1.1.jar  /opt/soft/tools/tomcat/lib
cp /opt/soft/activation-1.1.1.jar  /opt/soft/tools/tomcat/lib
cp /opt/soft/mail-1.4.jar  /opt/soft/tools/tomcat/lib





mvn dependency:get -DgroupId=org.apache.archiva -DartifactId=archiva-webapp -Dversion=2.2.10  -Dpackaging=war;cp /root/.m2/repository/org/apache/archiva/archiva-webapp/2.2.10/archiva-webapp-2.2.10.war /opt/soft/
cp /opt/soft/archiva-webapp-2.2.10.war  /opt/soft/archiva-webapp.war
mkdir -p /opt/soft/tools/tomcat/conf/Catalina/localhost
cp /archiva.xml  /opt/soft/tools/tomcat/conf/Catalina/localhost/archiva.xml
#cp /archiva.xml  /opt/soft/tools/tomcat/conf/archiva.xml